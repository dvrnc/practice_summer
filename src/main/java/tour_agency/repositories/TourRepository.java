package tour_agency.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.time.LocalDate;
import java.util.Set;

public interface TourRepository extends GeneralRepository <TourEntity, Long> {

    @Query(value = "select t from TourEntity t " +
            "join t.featureEntitySet f where f in : featureEntitySet")
    Set<TourEntity> findByFeatureEntitySet (@Param(value = "featureEntitySet")
                                            Set<FeatureEntity> featureEntitySet);

    @Query(value = "SELECT t FROM TourEntity t WHERE " +
            "(:direction IS NULL OR t.direction = :direction) AND " +
                    "(:costLow IS NULL OR t.cost >= :costLow) AND " +
                    "(:costHigh IS NULL OR t.cost <= :costHigh) AND " +
                    "(:numberSeatsLow IS NULL OR t.numberSeats >= :numberSeatsLow) AND " +
                    "(:numberSeatsHigh IS NULL OR t.numberSeats <= :numberSeatsHigh) AND " +
                    "(:startDate IS NULL OR t.startDate >= :startDate) AND " +
                    "(:finishDate IS NULL OR t.finishDate <= :finishDate)")
    Set <TourEntity> findToursByCriteria(@Param("direction") String direction,
                                         @Param("costLow") Integer costLow,
                                         @Param("costHigh") Integer costHigh,
                                         @Param("numberSeatsLow") Integer numberSeatsLow,
                                         @Param("numberSeatsHigh") Integer numberSeatsHigh,
                                         @Param("startDate") LocalDate startDate,
                                         @Param("finishDate") LocalDate finishDate);

//    @Query(value = "select t from TourEntity t where t.startDate between :startDate and :finishDate")
//    Set<TourEntity> findAllByToursDate (@Param("startDate") Date startDate,
//                                                 @Param("endDate")  Date finishDate);
//
//    @Query("select t from TourEntity t group by t.direction order by COUNT(t.direction) DESC")
//    Set <String> findMostDirectoinStatus();
//
//    @Query("select t from TourEntity t group by t.cost order by COUNT(t.cost) DESC")
//    Set <Integer> findCostStatus();
//
//    @Query("select distinct t from TourEntity t join t.bookingEntitySet b where b.client.id = :clientId")
//    Set <TourEntity> findToursByClientId (@Param("clientId") Long clientId);
//
    @Query("select b.tour from BookingEntity b where b.client.id = :clientId group by b.tour order by COUNT(b.tour) DESC")
    Set <TourEntity> findBookingHistoryByClient (@Param("clientId") Long clientId);

}

