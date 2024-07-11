package tour_agency.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Carrier")
public class CarrierEntity {

    private Long id;

    private String transport;

    private String nameCompany;

    private Integer costTransportation;

    private List<TourEntity> tourEntityList;


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
    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Column
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Column
    public Integer getCostTransportation() {
        return costTransportation;
    }

    public void setCostTransportation(Integer costTransportation) {
        this.costTransportation = costTransportation;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = TourEntity.class, mappedBy = "carrier")
    public List<TourEntity> getTourEntityList() {
        return tourEntityList;
    }

    public void setTourEntityList(List<TourEntity> tourEntityList) {
        this.tourEntityList = tourEntityList;
    }
}
