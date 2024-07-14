package tour_agency.services.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tour_agency.DTO.ClientDTO;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.ClientRepository;
import tour_agency.repositories.FeatureRepository;
import tour_agency.repositories.TourRepository;
import tour_agency.services.TourRecommendService;
import java.util.Collections;
import java.util.Set;

@Service
public class TourRecommendServiceImpl implements TourRecommendService {
    private final ClientRepository clientRepository;
    private final FeatureRepository featureRepository;
    private final TourRepository tourRepository;

    public TourRecommendServiceImpl(ClientRepository clientRepository, FeatureRepository featureRepository, TourRepository tourRepository) {
        this.clientRepository = clientRepository;
        this.featureRepository = featureRepository;
        this.tourRepository = tourRepository;
    }

    @Override
    public Set<TourEntity> recommendTours(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.findByClientId(clientDTO.getId());
        if (clientEntity == null) {
            throw new EntityNotFoundException();
        }
        Set<ClientEntity> clientEntitySet = Collections.singleton(clientEntity);
        Set<FeatureEntity> featureEntities = featureRepository.findByClient(clientEntitySet);
        Set<TourEntity> tourEntitySet = tourRepository.findByFeatureEntitySet (featureEntities);
        return tourEntitySet;
    }
}
