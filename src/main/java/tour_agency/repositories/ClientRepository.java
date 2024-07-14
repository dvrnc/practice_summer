package tour_agency.repositories;

import tour_agency.entities.ClientEntity;


public interface ClientRepository extends GeneralRepository <ClientEntity, Long> {
    ClientEntity findByClientId(Long id);
}
