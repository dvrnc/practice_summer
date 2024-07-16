package tour_agency.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;

import java.util.Set;

@Repository
public interface FeatureRepository extends GeneralRepository<FeatureEntity, Long> {
    @Query(value = "select f from FeatureEntity f " +
            "join f.clientEntitySet c where c in :clients")
    Set<FeatureEntity> findByClient(@Param(value = "clients")
                                    Set<ClientEntity> clients);
}
