package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Sort;

import be.vdab.entities.Jobtitel;

public interface JobtitelService {
	List<Jobtitel> findAll(Sort sort);
}
