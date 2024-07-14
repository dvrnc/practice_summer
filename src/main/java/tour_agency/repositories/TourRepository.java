package tour_agency.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.time.LocalDate;
import java.util.Set;

public interface TourRepository extends GeneralRepository<TourEntity, Long> {

    @Query(value = "select t from TourEntity t " +
            "join t.featureEntitySet f where f in : featureEntitySet")
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
    Set<TourEntity> findToursByCriteria(@Param("direction") String direction,
                                        @Param("costLow") Integer costLow,
                                        @Param("costHigh") Integer costHigh,
                                        @Param("numberSeatsLow") Integer numberSeatsLow,
                                        @Param("numberSeatsHigh") Integer numberSeatsHigh,
                                        @Param("startDate") LocalDate startDate,
                                        @Param("finishDate") LocalDate finishDate);

    @Query("select t from TourEntity t join t.bookingEntitySet b where b.client.id = :clientId group by t.id order by COUNT(t) desc")
    Set<TourEntity> findToursByClientId(Long clientId);


}

