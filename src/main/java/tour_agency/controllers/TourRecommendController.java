package tour_agency.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;
import tour_agency.services.TourRecommendService;

import java.util.Set;

@RestController
public class TourRecommendController {
    private final TourRecommendService tourRecommendService;


    public TourRecommendController(TourRecommendService tourRecommendService) {
        this.tourRecommendService = tourRecommendService;
    }
    @GetMapping("/recommendTours")
    public Set<TourDTO> recommendTours(@RequestBody ClientDTO clientDTO){
        System.out.println(clientDTO.getId());
        return tourRecommendService.recommendTours(clientDTO);
    }
}
