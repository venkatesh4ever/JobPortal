package com.vidur.news.dao.json;

public class Response {
	/*
		{"responseData": 
			{
			"results":
					{
		 	 "responseDetails": null, 
		 	 "responseStatus": 200
		 }
	 */
	ResponseData responseData = null;
	String responseDetails=null;
	int responseStatus;

	public ResponseData getResponseData() {
		return responseData;
	}
	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}
	public String getResponseDetails() {
		return responseDetails;
	}
	public void setResponseDetails(String responseDetails) {
		this.responseDetails = responseDetails;
	}
	public int getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

}
