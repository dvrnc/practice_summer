package tour_agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tour_agency.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
