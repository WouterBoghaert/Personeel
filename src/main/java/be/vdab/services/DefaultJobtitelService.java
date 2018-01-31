package be.vdab.services;

import be.vdab.repositories.JobtitelRepository;

@ReadOnlyTransactionalService
class DefaultJobtitelService implements JobtitelService {
	private final JobtitelRepository jobtitelRepository;

	protected DefaultJobtitelService(JobtitelRepository jobtitelRepository) {
		this.jobtitelRepository = jobtitelRepository;
	}
	
	
}
