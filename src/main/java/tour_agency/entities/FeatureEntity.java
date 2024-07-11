package tour_agency.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "feauters")
public class FeatureEntity extends BaseEntity {

    private String nameFeature;
    private Set<ClientEntity> clientEntitySet;
    private Set<TourEntity> tourEntitySet;

    public FeatureEntity(String nameFeature, Set<ClientEntity> clientEntitySet, Set<TourEntity> tourEntitySet) {
        this.nameFeature = nameFeature;
        this.clientEntitySet = clientEntitySet;
        this.tourEntitySet = tourEntitySet;
    }

    protected FeatureEntity() {
    }

    @Column(name = "name_feature")
    public String getNameFeature() {
        return nameFeature;
    }

    public void setNameFeature(String nameFeature) {
        this.nameFeature = nameFeature;
    }
    @ManyToMany(targetEntity = ClientEntity.class)
    @JoinTable(name = "clients_features")
    public Set<ClientEntity> getClientEntitySet() {
        return clientEntitySet;
    }

    public void setClientEntitySet(Set<ClientEntity> clientEntitySet) {
        this.clientEntitySet = clientEntitySet;
    }
    @ManyToMany(targetEntity = TourEntity.class)
    @JoinTable(name = "tours_features")
    public Set<TourEntity> getTourEntitySet() {
        return tourEntitySet;
    }

    public void setTourEntitySet(Set<TourEntity> tourEntitySet) {
        this.tourEntitySet = tourEntitySet;
    }
}
