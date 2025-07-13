package com.college.service;

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
}
