package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
	List<Werknemer> findByChefIsNull();
	List<Werknemer> findByJobtitelId(long id);
	List<Werknemer> findByChefId(long id);
	// find chef?
	
}
