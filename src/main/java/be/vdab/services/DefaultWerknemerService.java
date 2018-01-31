package be.vdab.services;

import be.vdab.repositories.WerknemerRepository;

@ReadOnlyTransactionalService
class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	protected DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}
	
	// methods die updaten met @ModifyingTransactionalServiceMethod , read committed
	
}
