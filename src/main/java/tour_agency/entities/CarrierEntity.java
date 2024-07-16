package tour_agency.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "carrier")
public class CarrierEntity extends BaseEntity {

    private String transport;
    private String nameCompany;
    private Integer costTransportation;
    private Set<TourEntity> tourEntitySet;

    public CarrierEntity(String transport, String nameCompany, Integer costTransportation, Set<TourEntity> tourEntitySet) {
        this.transport = transport;
        this.nameCompany = nameCompany;
        this.costTransportation = costTransportation;
        this.tourEntitySet = tourEntitySet;
    }

    protected CarrierEntity() {
    }

    @Column(name = "transport")
    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Column(name = "name_company")
    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Column(name = "cost_transportation")
    public Integer getCostTransportation() {
        return costTransportation;
    }

    public void setCostTransportation(Integer costTransportation) {
        this.costTransportation = costTransportation;
    }

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, targetEntity = TourEntity.class, mappedBy = "carrier")
    public Set<TourEntity> getTourEntitySet() {
        return tourEntitySet;
    }

    public void setTourEntitySet(Set<TourEntity> tourEntitySet) {
        this.tourEntitySet = tourEntitySet;
    }
}
