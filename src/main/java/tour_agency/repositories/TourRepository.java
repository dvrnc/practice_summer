package tour_agency.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tour_agency.entities.ClientEntity;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface TourRepository extends GeneralRepository<TourEntity, Long> {

    @Query(value = "select t from TourEntity t " +
            "join t.featureEntitySet f where f in :featureEntitySet")
    Set<TourEntity> findByFeatureEntitySet(@Param(value = "featureEntitySet")
                                           Set<FeatureEntity> featureEntitySet);

    @Query(value = "select t from TourEntity t where " +
            "(:direction is null or t.direction = :direction) and " +
            "(:costLow is null or t.cost >= :costLow) and" +
            "(:costHigh is null or t.cost <= :costHigh) and " +
            "(:numberSeatsLow is null or t.numberSeats >= :numberSeatsLow) and " +
            "(:numberSeatsHigh is null or t.numberSeats <= :numberSeatsHigh) and " +
            "(:startDate is null or t.startDate >= :startDate) and " +
            "(:finishDate is null or t.finishDate <= :finishDate)")
    Set<TourEntity> findToursByCriteria(@Param(value = "direction") String direction,
                                        @Param(value = "costLow") Integer costLow,
                                        @Param(value = "costHigh") Integer costHigh,
                                        @Param(value = "numberSeatsLow") Integer numberSeatsLow,
                                        @Param(value = "numberSeatsHigh") Integer numberSeatsHigh,
                                        @Param(value = "startDate") LocalDate startDate,
                                        @Param(value = "finishDate") LocalDate finishDate);

    @Query("select t from TourEntity t join t.bookingEntitySet b where b.client = :clientId group by t.id order by COUNT(t) desc ")
    Set<TourEntity> findToursByClientId(@Param(value = "clientId") ClientEntity clientId);

}

