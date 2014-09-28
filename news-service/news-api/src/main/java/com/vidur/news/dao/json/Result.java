package com.vidur.news.dao.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -8326916003473215546L;
	/*
		 		"GsearchResultClass":"GnewsSearch",
		 		"clusterUrl":"http://news.google.com/news/story?ncl\u003ddIFG3ICIJVK_h1MnDUl_JYXd9xYAM\u0026hl\u003den\u0026ned\u003dus",
		 		"content":"President \u003cb\u003eBarack Obama\u003c/b\u003e on Wednesday confirmed the authenticity of a video released by the Islamic State of Iraq and the Levant that showed the beheading of American journalist Steven Sotloff and vowed that the murder will only “stiffen” the U.S.\u0026#39;\u0026nbsp;...",
		 		"unescapedUrl":"http://www.politico.com/story/2014/09/obama-steven-sotloff-reaction-110540.html",
		 		"url":"http%3A%2F%2Fwww.politico.com%2Fstory%2F2014%2F09%2Fobama-steven-sotloff-reaction-110540.html",
		 		"title":"\u003cb\u003eBarack Obama\u003c/b\u003e vows \u0026#39;justice\u0026#39; for Steven Sotloff",
		 		"titleNoFormatting":"Barack Obama vows \u0026#39;justice\u0026#39; for Steven Sotloff",
		 		"location":"",
		 		"publisher":"Politico",
		 		"publishedDate":"Wed, 03 Sep 2014 03:06:35 -0700",
		 		"signedRedirectUrl":"http://news.google.com/news/url?sa\u003dT\u0026ct2\u003dus\u0026fd\u003dS\u0026url\u003dhttp://www.politico.com/story/2014/09/obama-steven-sotloff-reaction-110540.html\u0026cid\u003d52778599839867\u0026ei\u003dEUUIVLDCOITb4waugYGoDg\u0026usg\u003dAFQjCNGJglBewzjs1bL4nZw4jkY0ysw30w",
		 		"language":"en",
		 		"image":
		 		{
		 			"url":"http://static.guim.co.uk/sys-images/Guardian/About/General/2014/9/3/1409770476956/US-President-Barack-Obama-013.jpg",
		 			"tbUrl":"http://t0.gstatic.com/images?q\u003dtbn:ANd9GcRGWLW7FxXiCC5CQ_Lj_OA91B3R_ta15mAdtoJ_X5HZl3c7eokIKC2BxJKC",
		 			"originalContextUrl":"http://www.theguardian.com/world/2014/sep/03/barack-obama-muslim-countries-help-crushing-isis",
		 			"publisher":"The Guardian",
		 			"tbWidth":80,
		 			"tbHeight":48
		 		},
		 		"relatedStories":[]
 */
	String GsearchResultClass;
	String clusterUrl;
	String content;
	String unescapedUrl;
	String url;
	String title;
	String titleNoFormatting;
	String location;
	String publisher;
	String publishedDate;
	String signedRedirectUrl;
	String language;
	Image image;
	List<Result> relatedStories = new ArrayList<Result>();
	
	public String getGsearchResultClass() {
		return GsearchResultClass;
	}
	public void setGsearchResultClass(String gsearchResultClass) {
		GsearchResultClass = gsearchResultClass;
	}
	public String getClusterUrl() {
		return clusterUrl;
	}
	public void setClusterUrl(String clusterUrl) {
		this.clusterUrl = clusterUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Result> getRelatedStories() {
		return relatedStories;
	}
	public void setRelatedStories(List<Result> relatedStories) {
		this.relatedStories = relatedStories;
	}
}
