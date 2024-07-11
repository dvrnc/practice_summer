package tour_agency.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
    private Long id;

    private String name;

    private String surname;

    private LocalDate dateEmployment;

    private String contactNumber;


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
    public LocalDate getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(LocalDate dateEmployment) {
        this.dateEmployment = dateEmployment;
    }

    @Column
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
