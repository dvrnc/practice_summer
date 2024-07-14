package tour_agency.DTO;

import tour_agency.entities.BookingEntity;
import tour_agency.entities.CarrierEntity;
import tour_agency.entities.FeatureEntity;

import java.time.LocalDate;
import java.util.Set;

public class TourDTO {
    private Long id;
    private String direction;
    private Integer cost;
    private Integer numberSeats;
    private LocalDate startDate;
    private LocalDate finishDate;
    private CarrierEntity carrier;
    private Set<BookingEntity> bookingEntitySet;
    private Set<FeatureEntity> featureEntitySet;

    public TourDTO(Long id,String direction, Integer cost, Integer numberSeats, LocalDate startDate, LocalDate finishDate, CarrierEntity carrier, Set<BookingEntity> bookingEntitySet, Set<FeatureEntity> featureEntitySet) {
        this.id=id;
        this.direction = direction;
        this.cost = cost;
        this.numberSeats = numberSeats;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.carrier = carrier;
        this.bookingEntitySet = bookingEntitySet;
        this.featureEntitySet = featureEntitySet;
    }

    public TourDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public CarrierEntity getCarrier() {
        return carrier;
    }

    public void setCarrier(CarrierEntity carrier) {
        this.carrier = carrier;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public Set<BookingEntity> getBookingEntitySet() {
        return bookingEntitySet;
    }

    public void setBookingEntitySet(Set<BookingEntity> bookingEntitySet) {
        this.bookingEntitySet = bookingEntitySet;
    }

    public Set<FeatureEntity> getFeatureEntitySet() {
        return featureEntitySet;
    }

    public void setFeatureEntitySet(Set<FeatureEntity> featureEntitySet) {
        this.featureEntitySet = featureEntitySet;
    }
}
