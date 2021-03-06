package be.vdab.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
	@EntityGraph("Werknemer.metJobtitel")
	Optional<Werknemer> findByChefIsNull();
	List<Werknemer> findByJobtitelId(long id);
	List<Werknemer> findByChefId(long id);
}
