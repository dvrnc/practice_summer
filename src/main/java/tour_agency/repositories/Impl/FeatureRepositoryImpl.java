package tour_agency.repositories.Impl;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.repositories.BaseRepository;
import tour_agency.repositories.FeatureRepository;

import java.util.List;
@Repository
public class FeatureRepositoryImpl extends BaseRepository<FeatureEntity, Long> implements FeatureRepository {

    @Override
    public List<FeatureEntity> findByClient (List <ClientEntity> clients) {
        String jpql = "select f from FeatureEntity f join f.clientEntitySet c where c in :clients";
        TypedQuery<FeatureEntity> query = entityManager.createQuery(jpql, FeatureEntity.class);
        query.setParameter("clients", clients);
        return query.getResultList();
    }
}
