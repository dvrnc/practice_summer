package tour_agency.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tour_agency.entities.BookingEntity;
import tour_agency.entities.TourEntity;

import java.util.Set;

public interface BookingRepository extends GeneralRepository <BookingEntity, Long> {

}
