/**
 * 
 */
package com.jfe.dao;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.DBCollection;
import com.jfe.model.Person;
import com.jfe.model.Seeker;
import com.jfe.resources.Constants;

/**
 * @author Venkatesh
 *
 */
@Service
public class SeekerDAOImpl implements SeekerDAO {
	
	private final static Logger logger = LoggerFactory.getLogger(SeekerDAOImpl.class);
	
	@Autowired
	private MongoOperations mongoOperation;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired(required=true)
	private SequenceDAO sequenceDAO;
	
	@Qualifier("sequenceDAO")
    public void setSequenceDAO(SequenceDAO sequenceDAO){
        this.sequenceDAO = sequenceDAO;
    }
 

	@Override
	public String mongoSeeekerInfo(String email, String password) {
		logger.debug("Values in DAO >>>"+email+"|"+password);
		
		Seeker seeker = seekerExists(email);
		if(seeker != null) {
			
			/*BasicDBObject seekerDoc = new BasicDBObject();
			seekerDoc.put("user", email);
			seekerDoc.put("password", password);
		 
			BasicDBObject searchQuery = new BasicDBObject().append("user", email);
			//DBCollection collection = dbCollection.getCollection("seeker");
			logger.debug("search and update seeker collection");
			logger.debug("searchQuery to update >>"+searchQuery.toString());
			DBCollection collection = getCollections("seeker");
			if(collection != null)
				collection.update(searchQuery, seekerDoc);*/
			//logger.debug("User email >>>"+email+" is exists, old password>>>"+seeker.getPassword());
			//seeker.setPassword(password);
			
			mongoOperation.save(seeker);
		}else {
			seeker = new Seeker();
			seeker.setId(sequenceDAO.getNextSeekerSequence(Constants.SEEKER_SEQUENCE));
			seeker.setUser(email);
			//seeker.setPassword(password);
			//logger.debug("User email >>>"+email+" doesn't exists, and password>>>"+password);
			
			mongoOperation.save(seeker);
		}
		
		return Constants.SUCCESS;
	}
	
	public Seeker seekerExists(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("user").is(email));
		Seeker seeker = mongoOperation.findOne(query, Seeker.class);
		logger.debug("seeker debug query >> "+query.toString());
		
		return seeker;
	}
	
	public DBCollection getCollections(String coll) {
		
		DBCollection collection = null;
		if (!mongoTemplate.getCollectionNames().contains(coll)) {
		    collection = mongoTemplate.createCollection(coll);
		    logger.debug("Collection found in DB >>>"+coll);
		}
		
		return collection;

		//mongoTemplate.dropCollection("MyNewCollection");
	}


	@Override
	public String saveSeeker(Seeker seeker) {
		Seeker seeker1 = seekerExists(seeker.getUser());
		if(seeker1 != null) {
			logger.debug("Seeker detail >>>"+seeker.getUser());
			mongoOperation.save(seeker);
		}else {
			seeker1 = new Seeker();
			seeker1.setId(sequenceDAO.getNextSeekerSequence(Constants.SEEKER_SEQUENCE));
			seeker1.setUser(seeker.getUser());
			seeker1.setLocation(seeker.getLocation());
			seeker1.setExpectedRate(seeker.getExpectedRate());
			seeker1.setPerRate(seeker.getPerRate());
			seeker1.setTags(seeker.getTags());
			seeker1.setDomain(seeker.getDomain());
			seeker1.setDocument(seeker.getDocument());
			seeker1.setUrl(seeker.getUrl());
			seeker1.setAudio(seeker.getAudio());
			seeker1.setVedio(seeker.getVedio());
			logger.debug("Seeker info >>>"+seeker.getUser()+" doesn't exists");
			
			mongoOperation.save(seeker1);
		}
		
		return Constants.SUCCESS;
	}

	@Override
	public String savePersonDetails(Person person) {
		
		Person person2 = isPersonExists(person);
		
		if(person2 != null) {
			logger.debug("User is already available >>"+person2.getProfileName());
			mongoOperation.save(person2);
		}else {
			logger.debug("User is not available >>"+person.getProfileName());
			person.setId(sequenceDAO.getNextSeekerSequence(Constants.PERSON_SEQUENCE));
			mongoOperation.save(person);
		}
		
		return Constants.SUCCESS;
	}
	
	public Person isPersonExists(Person person) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(person.getEmail()));
		Person person2 = mongoOperation.findOne(query, Person.class);
		logger.debug("Person debug query >> "+query.toString());
		
		return person2;
	}

}
