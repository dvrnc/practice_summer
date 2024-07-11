package tour_agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tour_agency.entities.BookingEntity;

public interface BookingRepository extends JpaRepository <BookingEntity, Long> {
}
