/*
 * Copyright 2012 FuseSource
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vidur.news.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vidur.news.CollectNewsFault;
import com.vidur.news.News;
import com.vidur.news.SaveNewsFault;

public class NewsImpl implements News {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	// @Override
	public String collectNews(String collectNewsRequestType)
			throws CollectNewsFault {
		String returnValue = null;
		try {
			System.out.println("In Webservice ....");
			URL url = new URL(
					"https://ajax.googleapis.com/ajax/services/search/news?"
							+ "v=1.0&q=" + collectNewsRequestType
							+ "&userip=INSERT-USER-IP");
			URLConnection connection = url.openConnection();
			connection.addRequestProperty("Referer", "http://localhost:9090");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			returnValue = stringBuilder.toString();
		} catch (Exception exception) {
			returnValue = "Exception while reading news from google";
			exception.printStackTrace();
		}
		return returnValue;
	}

	// @Override
	public String saveNews(String requestType) throws SaveNewsFault {
		// TODO Auto-generated method stub
		/*
		 * try {
		 * 
		 * Mongo mongo = new Mongo("localhost", 27017); DB db =
		 * mongo.getDB("newsdb");
		 * 
		 * DBCollection collection = db.getCollection( // 1. BasicDBObject
		 * example System.out.println("BasicDBObject example..."); BasicDBObject
		 * document = new BasicDBObject(); document.put("database", "mkyongDB");
		 * document.put("table", "hosting");
		 * 
		 * BasicDBObject documentDetail = new BasicDBObject();
		 * documentDetail.put("records", 99); documentDetail.put("index",
		 * "vps_index1"); documentDetail.put("active", "true");
		 * document.put("detail", documentDetail);
		 * 
		 * collection.insert(document); } catch (UnknownHostException e) {
		 * e.printStackTrace(); } catch (MongoException e) {
		 * e.printStackTrace(); }
		 */
		return "Vidur Tech " + requestType;
	}

	public static void main(String[] args) {
		try {
			NewsImpl news = new NewsImpl();
			news.collectNews("TEST");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}