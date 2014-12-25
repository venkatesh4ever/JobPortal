/**
 * 
 */
package com.jfe.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jfe.model.Data;

/**
 * @author Venkatesh
 *
 */
@Service
public class DataDAOImpl implements DataDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(DataDAOImpl.class);
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public String getData(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Data data = mongoOperation.findOne(query, Data.class);
		logger.debug("getData debug query >> "+query.toString());
		if(data != null)
			return data.getData();
		return "";
	}

	@Override
	public Data getDatas(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Data data = mongoOperation.findOne(query, Data.class);
		logger.debug("getDatas debug query >> "+query.toString());
		return data;
	}

	@Override
	public void setData(String userId, String data) {
		Data datas = new Data();
		datas.setUserId(userId);
		datas.setData(data);
		logger.debug("Save Data. user>>>"+userId+", data>>>"+data);
		mongoOperation.save(datas);
	}

	@Override
	public void setDate(Data data) {
		if(data != null) {
			logger.debug("Save Data. user>>>"+data.getUserId()+", data>>>"+data.getData());
			mongoOperation.save(data);
		}
	}

}
