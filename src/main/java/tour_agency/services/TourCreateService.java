package tour_agency.services;

import tour_agency.DTO.ParametrsDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;

import java.util.Set;


public interface TourCreateService {
    Set<TourEntity> findtours (ParametrsDTO parametrsDTO);
}
