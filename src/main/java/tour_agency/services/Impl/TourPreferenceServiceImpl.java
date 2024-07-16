package tour_agency.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tour_agency.DTO.ParametrsDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourPreferenceService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TourPreferenceServiceImpl implements TourPreferenceService {
    private final TourRepository tourRepository;
    private final ModelMapper modelMapper;

    public TourPreferenceServiceImpl(TourRepository tourRepository, ModelMapper modelMapper) {
        this.tourRepository = tourRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<TourDTO> findTours(ParametrsDTO parametrsDTO) {
        System.out.println(parametrsDTO);
        Set<TourEntity> tourEntities = tourRepository.findToursByCriteria(
                parametrsDTO.getDirection(),
                parametrsDTO.getCostLow(),
                parametrsDTO.getCostHigh(),
                parametrsDTO.getNumberSeatsLow(),
                parametrsDTO.getNumberSeatsHigh(),
                parametrsDTO.getStartDate(),
                parametrsDTO.getFinishDate()
        );
        Set<TourDTO> tourDTOs = tourEntities.stream()
                .map(tourEntity -> modelMapper.map(tourEntity, TourDTO.class))
                .collect(Collectors.toSet());
        return tourDTOs;
    }
}

