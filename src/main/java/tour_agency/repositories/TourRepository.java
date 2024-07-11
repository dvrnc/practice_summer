package tour_agency.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.util.List;
import java.util.Set;

public interface TourRepository extends JpaRepository<TourEntity, Long> {

    @Query(value = "select t from TourEntity t " +
            "join t.featureEntitySet f where f in : featureEntitySet")
    List<TourEntity> FindByFeatureEntitySet (@Param(value = "featureEntitySet")
                                            Set<FeatureEntity> featureEntitySet);

}

