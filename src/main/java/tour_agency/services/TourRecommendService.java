package tour_agency.services;

import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;

import java.util.Set;

public interface TourRecommendService {
    Set<TourDTO> recommendTours(ClientDTO clientDTO);
}
