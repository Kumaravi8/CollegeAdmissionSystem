package com.college.service;

import com.college.model.Application;
import java.util.List;

public interface ApplicationService {
	boolean addApplication(Application application);

	Application getApplicationById(int applicationId);

	List<Application> getAllApplications();

	boolean updateApplication(Application application);

	boolean deleteApplication(int applicationId);
	
	List<Application> getMeritList(int cutoffMarks);
}
