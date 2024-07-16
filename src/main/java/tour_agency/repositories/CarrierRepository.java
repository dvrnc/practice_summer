package tour_agency.repositories;

import org.springframework.stereotype.Repository;
import tour_agency.entities.CarrierEntity;
@Repository
public interface CarrierRepository extends GeneralRepository<CarrierEntity, Long> {
}
