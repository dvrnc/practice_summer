package tour_agency.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tour")
public class TourEntity extends BaseEntity {

    private String direction;
    private Integer cost;
    private Integer numberSeats;
    private LocalDate startDate;
    private LocalDate finishDate;
    private CarrierEntity carrier;
    private Set<BookingEntity> bookingEntitySet;
    private Set<FeatureEntity> featureEntitySet;

    public TourEntity(String direction, Integer cost, Integer numberSeats, LocalDate startDate, LocalDate finishDate, CarrierEntity carrier, Set<BookingEntity> bookingEntitySet, Set<FeatureEntity> featureEntitySet) {
        this.direction = direction;
        this.cost = cost;
        this.numberSeats = numberSeats;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.carrier = carrier;
        this.bookingEntitySet = bookingEntitySet;
        this.featureEntitySet = featureEntitySet;
    }

    protected TourEntity() {
    }

    @Column(name = "direction")
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Column(name = "cost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "number_seats")
    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    @Column(name = "start_date")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "finish_date")
    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    public CarrierEntity getCarrier() {
        return carrier;
    }

    public void setCarrier(CarrierEntity idCarrier) {
        this.carrier = idCarrier;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "tour")
    public Set<BookingEntity> getBookingEntitySet() {
        return bookingEntitySet;
    }

    public void setBookingEntitySet(Set<BookingEntity> bookingEntitySet) {
        this.bookingEntitySet = bookingEntitySet;
    }

    @ManyToMany(mappedBy = "tourEntitySet", targetEntity = FeatureEntity.class)
    public Set<FeatureEntity> getFeatureEntitySet() {
        return featureEntitySet;
    }

    public void setFeatureEntitySet(Set<FeatureEntity> featureEntitySet) {
        this.featureEntitySet = featureEntitySet;
    }
}
