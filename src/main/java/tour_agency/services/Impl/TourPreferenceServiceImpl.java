package tour_agency.services.Impl;

import tour_agency.DTO.ParametrsDTO;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourPreferenceService;

import java.util.Set;

public class TourPreferenceServiceImpl implements TourPreferenceService {
    private final TourRepository tourRepository;

    public TourPreferenceServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Set<TourEntity> findtours(ParametrsDTO parametrsDTO) {
        Set<TourEntity> tourEntities = tourRepository.findToursByCriteria(
                parametrsDTO.getDirection(),
                parametrsDTO.getCostLow(),
                parametrsDTO.getCostHigh(),
                parametrsDTO.getNumberSeatsLow(),
                parametrsDTO.getNumberSeatsHigh(),
                parametrsDTO.getStartDate(),
                parametrsDTO.getFinishDate()

        );
        return tourEntities;
    }
}
