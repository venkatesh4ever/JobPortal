/**
 * 
 */
package com.jfe.controller;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * @author Venkatesh
 *
 */
public class MongoTest {
	
	public static void main(String a[]) {
		
		try {
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			DB db = mongoClient.getDB("web-news");
			
			DBCollection table1 = db.getCollection("users");
			System.out.println("Table Details before authentication >>"+table1.getName());
			
			boolean auth = db.authenticate("mongo", "mongo".toCharArray());
			
			if(auth) {
				System.out.println("Authentication succedded. DB & users exist");
			}else {
				System.out.println("Authentication failed using user mongo");
			}
			
			List<String> dbs = mongoClient.getDatabaseNames();
			for(String databases : dbs){
				System.out.println("Database >>" +databases);
			}
			
			DBCollection table = db.getCollection("users");
			System.out.println("Table Details >>"+table.getName());
			
			Set<String> tables = db.getCollectionNames();
			 
			for(String coll : tables){
				System.out.println("Set of tables >>"+coll);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
