package tour_agency.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String features;
    private Set<BookingEntity> bookingEntitySet;

    public ClientEntity(String name, String surname, String email, Set<BookingEntity> bookingEntitySet, String features) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bookingEntitySet = bookingEntitySet;
        this.features = features;
    }

    protected ClientEntity() {
    }

    @Column (name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column (name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column (name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column (name = "features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "client")
    public Set<BookingEntity> getBookingEntitySet() {
        return bookingEntitySet;
    }

    public void setBookingEntitySet (Set<BookingEntity> bookingEntitySet) {
        this.bookingEntitySet = bookingEntitySet;
    }
}
