package com.college.dao;

import com.college.model.Application;
import java.util.List;

public interface ApplicationDAO {
	boolean insertApplication(Application application);

	Application getApplicationById(int applicationId);

	List<Application> getAllApplications();

	boolean updateApplication(Application application);

	boolean deleteApplication(int applicationId);
}
