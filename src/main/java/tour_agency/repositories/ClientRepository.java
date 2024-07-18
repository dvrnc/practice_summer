package tour_agency.repositories;

import tour_agency.entities.ClientEntity;

public interface ClientRepository  {
    ClientEntity findById(Long id);
}
