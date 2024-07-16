package tour_agency.repositories;

import org.springframework.stereotype.Repository;
import tour_agency.entities.EmployeeEntity;
@Repository
public interface EmployeeRepository extends GeneralRepository<EmployeeEntity, Long> {
}
