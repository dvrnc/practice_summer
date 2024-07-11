package tour_agency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tour_agency.entities.FeatureEntity;

public interface FeatureRepository extends JpaRepository <FeatureRepository, Long> {
}
