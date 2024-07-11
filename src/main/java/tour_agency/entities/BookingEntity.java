package tour_agency.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class BookingEntity extends BaseEntity {

    private ClientEntity client;
    private TourEntity tour;
    private EmployeeEntity employee;
    private LocalDate dateBooking;

    public BookingEntity(ClientEntity client, TourEntity tour, EmployeeEntity employee, LocalDate dateBooking) {
        this.client = client;
        this.tour = tour;
        this.employee = employee;
        this.dateBooking = dateBooking;
    }

    protected BookingEntity() {
    }

    @Column(name = "date_booking")
    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    public TourEntity getTour() {
        return tour;
    }

    public void setTour(TourEntity tour) {
        this.tour = tour;
    }
}
