package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Sort;

import be.vdab.entities.Jobtitel;
import be.vdab.repositories.JobtitelRepository;

@ReadOnlyTransactionalService
class DefaultJobtitelService implements JobtitelService {
	private final JobtitelRepository jobtitelRepository;

	protected DefaultJobtitelService(JobtitelRepository jobtitelRepository) {
		this.jobtitelRepository = jobtitelRepository;
	}

	@Override
	public List<Jobtitel> findAll(Sort sort) {
		return jobtitelRepository.findAll(sort);
	}
	
	
}
