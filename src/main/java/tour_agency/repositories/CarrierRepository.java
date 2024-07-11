package tour_agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tour_agency.entities.CarrierEntity;

public interface CarrierRepository extends JpaRepository<CarrierEntity, Long> {
}
