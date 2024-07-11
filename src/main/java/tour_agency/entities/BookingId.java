package tour_agency.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookingId implements Serializable {

    private Long clientId;
    private Long tourId;

    public BookingId(Long clientId, Long tourId) {
        this.clientId = clientId;
        this.tourId = tourId;
    }

    public BookingId() {
    }

    @Column(name = "client_id")
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Column(name = "tour_id")
    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }
}
