package tour_agency.DTO;

import tour_agency.entities.BookingEntity;
import tour_agency.entities.FeatureEntity;

import java.util.Set;

public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Set<FeatureEntity> featureEntitySet;
    private Set<BookingEntity> bookingEntitySet;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String surname, String email, Set<FeatureEntity> featureEntitySet, Set<BookingEntity> bookingEntitySet) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.featureEntitySet = featureEntitySet;
        this.bookingEntitySet = bookingEntitySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<FeatureEntity> getFeatureEntitySet() {
        return featureEntitySet;
    }

    public void setFeatureEntitySet(Set<FeatureEntity> featureEntitySet) {
        this.featureEntitySet = featureEntitySet;
    }

    public Set<BookingEntity> getBookingEntitySet() {
        return bookingEntitySet;
    }

    public void setBookingEntitySet(Set<BookingEntity> bookingEntitySet) {
        this.bookingEntitySet = bookingEntitySet;
    }
}
