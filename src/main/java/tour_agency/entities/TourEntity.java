package tour_agency.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Tour")
public class TourEntity {
    private Long id;

    private String direction;

    private Integer cost;

    private Integer numberSeats;

    private LocalDate startDate;

    private LocalDate finishDate;

    private CarrierEntity carrier;

    private List<BookingEntity> bookingEntityList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Column
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column
    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    @Column
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column
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
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }
}
