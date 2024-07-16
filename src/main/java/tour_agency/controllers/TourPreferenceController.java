package tour_agency.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tour_agency.DTO.ParametrsDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;
import tour_agency.services.TourPreferenceService;

import java.util.Set;

@RestController
public class TourPreferenceController {
    private final TourPreferenceService tourPreferenceService;

    public TourPreferenceController(TourPreferenceService tourPreferenceService) {
        this.tourPreferenceService = tourPreferenceService;
    }
    @GetMapping("/findToursPreference")
    public Set<TourDTO> findTours(ParametrsDTO parametrsDTO) {
        return tourPreferenceService.findTours(parametrsDTO);
    }
}
