package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerCheckService {
	boolean CheckIfRealJobSeeker(JobSeeker jobSeeker);
}
