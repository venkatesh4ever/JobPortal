package com.vidur.news.dao.json;

public class Story {
/*
 * unescapedUrl":"http://www.telegraph.co.uk/news/worldnews/barackobama/11071803/Watch-live-Barack-Obama-responds-to-beheading-of-Steven-Sotloff.html",
	 				 		"url":"http%3A%2F%2Fwww.telegraph.co.uk%2Fnews%2Fworldnews%2Fbarackobama%2F11071803%2FWatch-live-Barack-Obama-responds-to-beheading-of-Steven-Sotloff.html",
	 				 		"title":"Watch live: \u003cb\u003eBarack Obama\u003c/b\u003e responds to beheading of Steven Sotloff",
	 				 		"titleNoFormatting":"Watch live: Barack Obama responds to beheading of Steven Sotloff",
	 				 		"location":"",
	 				 		"publisher":"Telegraph.co.uk",
	 				 		"publishedDate":"Wed, 03 Sep 2014 01:52:08 -0700",
	 				 		"signedRedirectUrl":"http://news.google.com/news/url?sa\u003dT\u0026ct2\u003dus\u0026fd\u003dS\u0026url\u003dhttp://www.telegraph.co.uk/news/worldnews/barackobama/11071803/Watch-live-Barack-Obama-responds-to-beheading-of-Steven-Sotloff.html\u0026cid\u003d52778599839867\u0026ei\u003dEUUIVLDCOITb4waugYGoDg\u0026usg\u003dAFQjCNFGyx0zDLYBbnp5-o2jK-Afp3_Mow",
	 				 		"language":"en"
 */
	String unescapedUrl;
	public String getUnescapedUrl() {
		return unescapedUrl;
	}
	public void setUnescapedUrl(String unescapedUrl) {
		this.unescapedUrl = unescapedUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleNoFormatting() {
		return titleNoFormatting;
	}
	public void setTitleNoFormatting(String titleNoFormatting) {
		this.titleNoFormatting = titleNoFormatting;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getSignedRedirectUrl() {
		return signedRedirectUrl;
	}
	public void setSignedRedirectUrl(String signedRedirectUrl) {
		this.signedRedirectUrl = signedRedirectUrl;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	String url;
	String title;
	String titleNoFormatting;
	String location;
	String publisher;
	String publishedDate;
	String signedRedirectUrl;
	String language;
}
