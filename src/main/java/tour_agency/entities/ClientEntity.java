package tour_agency.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Client")
public class ClientEntity {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String features;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = BookingEntity.class, mappedBy = "client")
    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }

}
