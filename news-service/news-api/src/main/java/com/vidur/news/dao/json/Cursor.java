package com.vidur.news.dao.json;

import java.util.ArrayList;
import java.util.List;

public class Cursor {
/*
			"cursor":
			{
				"pages":
					[
					 	{
					 		"start":"28",
					 		"label":8
					 	}
					 ],
				"estimatedResultCount":"6705158",
				"currentPageIndex":0,
				"moreResultsUrl":"http://news.google.com/nwshp?oe\u003dutf8\u0026ie\u003dutf8\u0026source\u003duds\u0026q\u003dbarack+obama\u0026hl\u003den\u0026start\u003d0"
			}
 */
	List<Layout> pages = new ArrayList<Layout>();
	String estimatedResultCount;
	int currentPageIndex;
	String moreResultsUrl;
	public List<Layout> getPages() {
		return pages;
	}
	public void setPages(List<Layout> pages) {
		this.pages = pages;
	}
	public String getEstimatedResultCount() {
		return estimatedResultCount;
	}
	public void setEstimatedResultCount(String estimatedResultCount) {
		this.estimatedResultCount = estimatedResultCount;
	}
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}
	public String getMoreResultsUrl() {
		return moreResultsUrl;
	}
	public void setMoreResultsUrl(String moreResultsUrl) {
		this.moreResultsUrl = moreResultsUrl;
	}

}
