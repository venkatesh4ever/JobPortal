package com.vidur.news.bean.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vidur.news.dao.json.Result;

public class NewsSplitImpl implements Processor {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public void process(Exchange exchange) throws Exception {
		String bodyString = exchange.getIn().getBody(String.class);
			ObjectMapper mapper = new ObjectMapper();
		ProducerTemplate camelProducerTemplate = exchange.getContext()
				.createProducerTemplate();
		try {
			JSONObject json = new JSONObject(bodyString);
			JSONObject responseData = json.getJSONObject("responseData");
			JSONArray results = responseData.getJSONArray("results");
			int numberOfStories = results.length();
			JSONObject storyParsing = null;
			List<Result> stories = new ArrayList<Result>();
			Result story = null;
			for (int eachStory = 0; eachStory < numberOfStories; eachStory++) {
				storyParsing = results.getJSONObject(eachStory);
				story = mapper.readValue(storyParsing.toString(), Result.class);
				log.info(eachStory + ". " + story.getTitle().toString());
				camelProducerTemplate.sendBody("activemq:queue:storyQueue",
						story);
/*				storyParsing = results.getJSONObject(0);
				story = mapper.readValue(storyParsing.toString(), Result.class);
				log.info(eachStory + ". " + story.getTitle().toString());
				camelProducerTemplate.sendBody("activemq:queue:storyQueue",
						story);
				break;*/
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
