package tour_agency.repositories;

import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.time.LocalDate;
import java.util.List;

public interface TourRepository {
    List <TourEntity> findByFeatureEntitySet (List<FeatureEntity> featureEntity);
    List <TourEntity> findToursByCriteria (String direction, Integer costLow, Integer costHigh, Integer numberSeatsLow, Integer numberSeatsHigh, LocalDate startDate, LocalDate finishDate);
    List <TourEntity> findToursByClientId (ClientEntity clientId);
    List<TourEntity> findToursByDirections(List<String> directions);
}

