package tour_agency.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.services.TourHistoryClientService;

import java.util.Set;

@RestController
public class TourHistoryClientController {
    private final TourHistoryClientService tourHistoryClientService;

    public TourHistoryClientController(TourHistoryClientService tourHistoryClientService) {
        this.tourHistoryClientService = tourHistoryClientService;
    }

    @GetMapping("/toursHistoryClient")
    public Set<TourDTO> historyClientTours(@RequestBody ClientDTO clientDTO) {
        return tourHistoryClientService.historyClientTours(clientDTO);
    }
}
