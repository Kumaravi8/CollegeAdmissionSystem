package com.college.service;
import java.util.*;
import com.college.dao.ApplicationDAO;
import com.college.dao.ApplicationDAOImpl;
import com.college.model.Application;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {

	private ApplicationDAO applicationDAO = new ApplicationDAOImpl();

	@Override
	public boolean addApplication(Application application) {
		// You can add business validations here before adding application
		return applicationDAO.insertApplication(application);
	}

	@Override
	public Application getApplicationById(int applicationId) {
		return applicationDAO.getApplicationById(applicationId);
	}

	@Override
	public List<Application> getAllApplications() {
		return applicationDAO.getAllApplications();
	}

	@Override
	public boolean updateApplication(Application application) {
		return applicationDAO.updateApplication(application);
	}

	@Override
	public boolean deleteApplication(int applicationId) {
		return applicationDAO.deleteApplication(applicationId);
	}
	 @Override
	    public List<Application> getMeritList(int cutoffMarks) {
	        
	        List<Application> allApplications = applicationDAO.getAllApplications();
	        List<Application> meritList = new ArrayList<>();

	       
	        for (Application app : allApplications) {
	           
	            
	            if (app.getMarks() >= cutoffMarks) {
	                meritList.add(app);
	            }
	        }
	        return meritList;
	    }
	 
	}

