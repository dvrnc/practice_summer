package tour_agency.repositories;

import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;

@Repository
public interface ClientRepository extends GeneralRepository<ClientEntity, Long> {
    ClientEntity findById(Long id);
}
