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
package com.vidur.news.bean.impl;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vidur.news.model.CollectNews;

public class PayloadImpl implements Processor {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	 public void process(Exchange exchange) throws Exception {
		 //CollectNews collectNews = new CollectNews();
		 //System.out.println("In Payload ETL ....");
		 //collectNews.setCollectNewsRequestType("IT");
/*		 String payload =	"<?xml version='1.0' ?> "
		 		+ " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:mod=\"http://vidur.com/news/model\">"
				 + "   <soapenv:Header/>"
				 + "   <soapenv:Body>"
				 + "      <mod:collectNews>"
				 + "         <mod:collectNewsRequestType>IT</mod:collectNewsRequestType>"
				 + "      </mod:collectNews>"
				 + "   </soapenv:Body>"
				 + "</soapenv:Envelope>";*/
	      // process the exchange
	      exchange.getOut().setBody("IT");
	   }
}