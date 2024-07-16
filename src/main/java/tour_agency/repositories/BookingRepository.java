package tour_agency.repositories;

import org.springframework.stereotype.Repository;
import tour_agency.entities.BookingEntity;

@Repository
public interface BookingRepository extends GeneralRepository<BookingEntity, Long> {
}
