/**
 * 
 */
package com.jfe.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.jfe.exception.SequenceException;
import com.jfe.model.SeekerSequence;

/**
 * @author Venkatesh
 *
 */
@Service
public class SequenceDAOImpl implements SequenceDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(SequenceDAOImpl.class);

	@Autowired
	private MongoOperations mongoOperation;

	@Override
	public long getNextSeekerSequence(String key) throws SequenceException {
		
		logger.debug("find the sequence key for >"+key);

		// get sequence id
		Query query = new Query(Criteria.where("_id").is(key));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		// this is the magic happened.
		SeekerSequence seqId = mongoOperation.findAndModify(query, update,
				options, SeekerSequence.class);
		
		logger.debug("found the sequence key for >"+seqId);

		// if no id, throws SequenceException
		// optional, just a way to tell user when the sequence id is failed to
		// generate.
		if (seqId == null) {
			throw new SequenceException("Unable to get sequence id for key : "
					+ key);
		}

		return seqId.getSeq();
	}

}
