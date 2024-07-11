package tour_agency.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

    private String name;

    private String surname;

    private LocalDate dateEmployment;

    private String contactNumber;

    public EmployeeEntity(String name, String surname, LocalDate dateEmployment, String contactNumber) {
        this.name = name;
        this.surname = surname;
        this.dateEmployment = dateEmployment;
        this.contactNumber = contactNumber;
    }

    protected EmployeeEntity() {
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

    @Column (name = "date_employment")
    public LocalDate getDateEmployment() {
        return dateEmployment;
    }

    public void setDateEmployment(LocalDate dateEmployment) {
        this.dateEmployment = dateEmployment;
    }

    @Column (name = "contact_number")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
