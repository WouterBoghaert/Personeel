package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Optional<Werknemer> findByChefIsNull();
	Optional<Werknemer> read(long id);
	void update(Werknemer werknemer);
	List<Werknemer> findByJobtitelId(long id);
	List<Werknemer> findByChefId(long id);
}
