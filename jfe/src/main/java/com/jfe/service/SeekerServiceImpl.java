/**
 * 
 */
package com.jfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jfe.dao.SeekerDAO;
import com.jfe.model.Person;
import com.jfe.model.Seeker;

/**
 * @author Venkatesh
 *
 */
@Service
public class SeekerServiceImpl implements SeekerService{
	
	@Autowired(required=true)
	private SeekerDAO seekerDAO;

    @Qualifier("seekerDAO")
    public void setSeekerDAO(SeekerDAO seekerDAO){
        this.seekerDAO = seekerDAO;
    }

	@Override
	public String saveSeekerInfo(String email, String password) {
		return seekerDAO.mongoSeeekerInfo(email, password);
	}

	@Override
	public String saveSeeker(Seeker seeker) {
		return seekerDAO.saveSeeker(seeker);
	}

	@Override
	public String savePersonDetails(Person person) {
		return seekerDAO.savePersonDetails(person);
	}

}
