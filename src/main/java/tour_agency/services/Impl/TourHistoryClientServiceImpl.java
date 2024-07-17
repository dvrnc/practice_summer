package tour_agency.services.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.TourEntity;
import tour_agency.exception.ClientNotFoundException;
import tour_agency.repositories.ClientRepository;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourHistoryClientService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TourHistoryClientServiceImpl implements TourHistoryClientService {
    private final TourRepository tourRepository;
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public TourHistoryClientServiceImpl(TourRepository tourRepository, ClientRepository clientRepository, ModelMapper modelMapper) {
        this.tourRepository = tourRepository;
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<TourDTO> historyClientTours(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.findById(clientDTO.getId()).orElseThrow(() -> new ClientNotFoundException("Client doesn't exist"));
        Set<TourEntity> tourEntitySet = tourRepository.findToursByClientId(clientEntity);
        Set<String> directions = tourEntitySet.stream().map(TourEntity::getDirection).collect(Collectors.toSet());
        Set<TourEntity> recommendations = tourRepository.findToursByDirections(directions);
        Set<TourEntity> checkedRecommendations = check(recommendations, clientEntity);
        Set<TourDTO> tourDTOs = checkedRecommendations.stream()
                .map(tourEntity -> modelMapper.map(tourEntity, TourDTO.class))
                .collect(Collectors.toSet());
        return tourDTOs;
    }
    private Set<TourEntity> check (Set<TourEntity> tourEntitySet, ClientEntity clientEntity){
        tourEntitySet.removeIf(tourEntity -> tourEntity.getBookingEntitySet().stream().anyMatch(bookingEntity -> bookingEntity.getClient().equals(clientEntity)));
        return tourEntitySet;
    }
}
