/**
 * 
 */
package com.jfe.dao;

import org.springframework.stereotype.Repository;

import com.jfe.model.Data;

/**
 * @author Venkatesh
 *
 */

@Repository
public interface DataDAO {
	
	public String getData(String userId);
	
	public Data getDatas(String userId);
	
	public void setData(String userId, String data);
	
	public void setDate(Data data);

}
