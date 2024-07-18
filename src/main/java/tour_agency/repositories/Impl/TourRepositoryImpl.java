package tour_agency.repositories.Impl;

import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;
import tour_agency.repositories.BaseRepository;
import tour_agency.repositories.TourRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TourRepositoryImpl extends BaseRepository<TourEntity, Long> implements TourRepository {

    @Override
    public List<TourEntity> findByFeatureEntitySet(List<FeatureEntity> featureEntitySet) {
        String jpql = "select t from TourEntity t join t.featureEntitySet f where f in :featureEntitySet";
        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
        query.setParameter("featureEntitySet", featureEntitySet);
        return query.getResultList();
    }

    @Override
    public List<TourEntity> findToursByCriteria(String direction, Integer costLow, Integer costHigh, Integer numberSeatsLow, Integer numberSeatsHigh, LocalDate startDate, LocalDate finishDate) {
        String jpql = "select t from TourEntity t where " +
                "(:direction is null or t.direction = :direction) and " +
                "(:costLow is null or t.cost >= :costLow) and " +
                "(:costHigh is null or t.cost <= :costHigh) and " +
                "(:numberSeatsLow is null or t.numberSeats >= :numberSeatsLow) and " +
                "(:numberSeatsHigh is null or t.numberSeats <= :numberSeatsHigh) and " +
                "(t.startDate >= :startDate) and " +
                "(t.finishDate <= :finishDate)";
        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
        query.setParameter("direction", direction);
        query.setParameter("costLow", costLow);
        query.setParameter("costHigh", costHigh);
        query.setParameter("numberSeatsLow", numberSeatsLow);
        query.setParameter("numberSeatsHigh", numberSeatsHigh);
        query.setParameter("startDate", startDate);
        query.setParameter("finishDate", finishDate);

        return query.getResultList();
    }

    public List<TourEntity> findToursByClientId(ClientEntity clientId) {
        String jpql = "select t from TourEntity t join t.bookingEntitySet b where b.client = :clientId group by t.id order by COUNT(t) desc";
        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
        query.setParameter("clientId", clientId);
        return query.getResultList();
    }

    public List<TourEntity> findToursByDirections(List<String> directions) {
        String jpql = "select t from TourEntity t where t.direction in :directions";
        TypedQuery<TourEntity> query = entityManager.createQuery(jpql, TourEntity.class);
        query.setParameter("directions", directions);
        return query.getResultList();
    }
}


