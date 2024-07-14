package tour_agency.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tour_agency.entities.FeatureEntity;
import tour_agency.entities.TourEntity;

import java.util.Date;
import java.util.Set;

public interface TourRepository extends GeneralRepository <TourEntity, Long> {

    @Query(value = "select t from TourEntity t " +
            "join t.featureEntitySet f where f in : featureEntitySet")
    Set<TourEntity> findByFeatureEntitySet (@Param(value = "featureEntitySet")
                                            Set<FeatureEntity> featureEntitySet);

    @Query(value = "select t from TourEntity t where t.startDate between :startDate and :finishDate")
    Set<TourEntity> findAllByToursDate (@Param("startDate") Date startDate,
                                                 @Param("endDate")  Date finishDate);

    @Query("select t from TourEntity t group by t.direction order by COUNT(t.direction) DESC")
    Set <String> findMostDirectoinStatus();

    @Query("select t from TourEntity t group by t.cost order by COUNT(t.cost) DESC")
    Set <Integer> findCostStatus();

    @Query("select distinct t from TourEntity t join t.bookingEntitySet b where b.client.id = :clientId")
    Set <TourEntity> findToursByClientId (@Param("clientId") Long clientId);

    @Query("select b.tour from BookingEntity b where b.client.id = :clientId group by b.tour order by COUNT(b.tour) DESC")
    Set <TourEntity> findBookingHistoryByClient (@Param("clientId") Long clientId);
}

