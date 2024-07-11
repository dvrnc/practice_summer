package tour_agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tour_agency.entities.ClientEntity;

public interface ClientRepository extends JpaRepository <ClientEntity, Long> {
}
