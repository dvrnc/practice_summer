package tour_agency.services.Impl;

import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourCreateService;
import java.util.HashSet;

public class TourCreateServiceImpl implements TourCreateService {
    private final TourRepository tourRepository;

    public TourCreateServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public void createTours(TourDTO tourDTO) {

        TourEntity tourEntity = new TourEntity(
                tourDTO.getDirection(),
                tourDTO.getCost(),
                tourDTO.getNumberSeats(),
                tourDTO.getStartDate(),
                null,
                tourDTO.getFinishDate(), new HashSet<>(), new HashSet<>());
        tourRepository.save(tourEntity);
    }
}
