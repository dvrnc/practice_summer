package tour_agency.services.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tour_agency.DTO.ClientDTO;
import tour_agency.DTO.TourDTO;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.ClientRepository;
import tour_agency.repositories.FeatureRepository;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourRecommendService;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TourRecommendServiceImpl implements TourRecommendService {
    private final ClientRepository clientRepository;
    private final FeatureRepository featureRepository;
    private final TourRepository tourRepository;
    private final ModelMapper modelMapper;

    public TourRecommendServiceImpl(ClientRepository clientRepository, FeatureRepository featureRepository, TourRepository tourRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.featureRepository = featureRepository;
        this.tourRepository = tourRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Set<TourDTO> recommendTours(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.findById(clientDTO.getId());
        if (clientEntity == null) {
            throw new EntityNotFoundException();
        }
        Set<ClientEntity> clientEntitySet = Collections.singleton(clientEntity);
        Set<FeatureEntity> featureEntities = featureRepository.findByClient(clientEntitySet);
        Set<TourEntity> tourEntitySet = tourRepository.findByFeatureEntitySet(featureEntities);
        Set <TourDTO> tourDTOs = tourEntitySet.stream()
                .map(tourEntity -> modelMapper.map(tourEntity, TourDTO.class))
                .collect(Collectors.toSet());
        return tourDTOs;
    }
}
