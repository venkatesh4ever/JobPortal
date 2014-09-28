package com.vidur.news.dao.json;

import java.io.Serializable;

public class Image implements Serializable{
/*
	"image":{
			"tbWidth":80,
			"originalContextUrl":"http://time.com/3264457/obama-europe-isis-nato/",
			"tbUrl":"http://t2.gstatic.com/images?q=tbn:ANd9GcQo0RaUX7Y3bHXRc6ngtPWYDAUT88jmAXVCB2ZCAiiHS1fTV8gfDTDElos",
			"tbHeight":53,
			"url":"http://timedotcom.files.wordpress.com/2014/09/barack-obama-estonia-europe.jpg?w=280",
			"publisher":"TIME"
		},
 */
	String url;
	String tbUrl;
	String publisher;
	String originalContextUrl;
	int tbWidth;
	int tbHeight;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTbUrl() {
		return tbUrl;
	}
	public void setTbUrl(String tbUrl) {
		this.tbUrl = tbUrl;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getOriginalContextUrl() {
		return originalContextUrl;
	}
	public void setOriginalContextUrl(String originalContextUrl) {
		this.originalContextUrl = originalContextUrl;
	}
	public int getTbWidth() {
		return tbWidth;
	}
	public void setTbWidth(int tbWidth) {
		this.tbWidth = tbWidth;
	}
	public int getTbHeight() {
		return tbHeight;
	}
	public void setTbHeight(int tbHeight) {
		this.tbHeight = tbHeight;
	}	
	
}
