package tour_agency.services;

import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;

import java.util.Set;

public interface TourRecommendService {
    Set<TourDTO> recommendTours(ClientDTO clientDTO);
}
