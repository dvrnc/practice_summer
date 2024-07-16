package tour_agency.services;

import tour_agency.DTO.ParametrsDTO;
import tour_agency.DTO.TourDTO;

import java.util.Set;


public interface TourPreferenceService {
    Set<TourDTO> findTours(ParametrsDTO parametrsDTO);
}
