package tour_agency.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client")
public class ClientEntity extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private Set<FeatureEntity> featureEntitySet;
    private Set<BookingEntity> bookingEntitySet;

    public ClientEntity(String name, String surname, String email, Set<BookingEntity> bookingEntitySet,Set<FeatureEntity> featureEntitiesSet ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.bookingEntitySet = bookingEntitySet;
        this.featureEntitySet = featureEntitiesSet;
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


    @ManyToMany(mappedBy = "clientEntitySet",targetEntity = FeatureEntity.class)
    public Set<FeatureEntity> getFeatureEntitiesSet() {
        return featureEntitySet;
    }

    public void setFeatureEntitiesSet(Set<FeatureEntity> featureEntitiesSet) {
        this.featureEntitySet = featureEntitiesSet;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "client")
    public Set<BookingEntity> getBookingEntitySet() {
        return bookingEntitySet;
    }

    public void setBookingEntitySet (Set<BookingEntity> bookingEntitySet) {
        this.bookingEntitySet = bookingEntitySet;
    }
}
