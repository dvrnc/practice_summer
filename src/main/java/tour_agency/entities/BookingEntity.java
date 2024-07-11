package tour_agency.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Booking")
public class BookingEntity {

    private BookingId id;
    private ClientEntity client;
    private TourEntity tour;
    private EmployeeEntity employee;
    private LocalDate dateBooking;

    @EmbeddedId
    public BookingId getId() {
        return id;
    }

    public void setId(BookingId id) {
        this.id = id;
    }

    @Column
    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @MapsId("clientId")
    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @MapsId("tourId")
    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }
}
