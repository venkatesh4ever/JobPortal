package com.vidur.news.bean.impl;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import com.vidur.news.dao.json.Result;

//public class QueueListener {
public class QueueListener implements MessageListener {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onMessage(Message message) {
		ObjectMapper mapper = new ObjectMapper();
		// Result message = new Result();
		// message.setLanguage("Delhi");
		log.info("In Listener >>>>> 1" + message);
		log.info("In Listener >>>>> 2" + message.getClass());
		if (message instanceof ActiveMQObjectMessage) {
			ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
			try {
				if (activeMQObjectMessage != null
						&& activeMQObjectMessage.getObject() instanceof Result) {
					Result result = (Result) activeMQObjectMessage.getObject();
					log.info("The object message recieved is >>>>> "
							+ result.getTitle());
					String userName = "news", password = "news";
					DB storyDb = new MongoClient("127.0.0.1", 27017)
							.getDB("news");
					boolean authentication = storyDb.authenticate(userName,
							password.toCharArray());
					log.info("The object message recieved is >>>>> "
							+ result.getTitle());
					if (authentication) {
						DBCollection collection = storyDb
								.getCollection("stories");
						String story = mapper.writeValueAsString(result);
						// JSONObject json = new JSONObject(result.toString());
						WriteResult writeResult = collection
								.insert((DBObject) JSON.parse(story));
						log.info("Upsert Id : " + writeResult);
						log.info("Object persisted .......");
					} else {
						log.info("Authentication Error .......");
					}
				} else {
					log.error("UnExpected Object in the queue expect : Result but recieved : " + activeMQObjectMessage.getClass());			
				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				log.error("JsonGenerationException : " + e.getCause());
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				log.error("JsonMappingException : " + e.getCause());
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("IOException : " + e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("Exception : " + e.getCause());
				e.printStackTrace();
			}
		} else {
			log.error("UnExpected Object in the queue expect : ActiveMQObjectMessage but recieved : " + message.getClass());			
		}
	}

	/*
	 * public static void main(String[] args) { new QueueListener().onMessage();
	 * }
	 */

}
