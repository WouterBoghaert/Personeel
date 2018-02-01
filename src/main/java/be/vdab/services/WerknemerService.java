package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Optional<Werknemer> findByChefIsNull();
/*	Optional<Werknemer> read(long id);*/
	void geefOpslag(Werknemer werknemer, BigDecimal bedrag);
	List<Werknemer> findByJobtitelId(long id);
	List<Werknemer> findByChefId(long id);
}
