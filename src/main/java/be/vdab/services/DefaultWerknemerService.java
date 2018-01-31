package be.vdab.services;

import java.util.List;
import java.util.Optional;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@ReadOnlyTransactionalService
class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	protected DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Optional<Werknemer> findByChefIsNull() {
		return werknemerRepository.findByChefIsNull();
	}

/*	@Override
	public Optional<Werknemer> read(long id) {
		return Optional.ofNullable(werknemerRepository.findOne(id));
	}
*/
	@Override
	@ModifyingTransactionalServiceMethod
	public void update(Werknemer werknemer) {
		werknemerRepository.save(werknemer);		
	}

	@Override
	public List<Werknemer> findByJobtitelId(long id) {
		return werknemerRepository.findByJobtitelId(id);
	}

	@Override
	public List<Werknemer> findByChefId(long id) {
		return werknemerRepository.findByChefId(id);
	}
	
	
	// methods die updaten met @ModifyingTransactionalServiceMethod , read committed
	
}
