package com.vidur.news.dao.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Results {
/*
		[
		 	Result
 		],
	 	"cursor":
 */
	List<Result> result = new ArrayList<Result>();
	Cursor cursor = new Cursor();
	public List<Result> getResult() {
		return result;
	}
	public void setResult(List<Result> result) {
		this.result = result;
	}
	public Cursor getCursor() {
		return cursor;
	}
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	
}
