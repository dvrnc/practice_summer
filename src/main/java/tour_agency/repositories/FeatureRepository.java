package tour_agency.repositories;

import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;

import java.util.List;

public interface FeatureRepository {
    List<FeatureEntity> findByClient(List<ClientEntity> clients);
}
