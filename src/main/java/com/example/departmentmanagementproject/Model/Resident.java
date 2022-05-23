package com.example.departmentmanagementproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resident_id", nullable = false)
    private int residentId;

    private String name;

    private String email;

    private String phoneNumber;

    @Column(unique = true, nullable = false, length = 255)
    private String IDNumber;

    private int birthYear;

    private boolean gender;

    @JsonIgnore
    @OneToMany(mappedBy = "resident")
    List<ApartmentDetail> lstApartmentDetails;

    public Resident() {
    }

    public Resident(String name, String email, String phoneNumber, String IDNumber,
                    int birthYear, boolean gender, List<ApartmentDetail> lstApartmentDetails) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.IDNumber = IDNumber;
        this.birthYear = birthYear;
        this.gender = gender;
        this.lstApartmentDetails = lstApartmentDetails;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public List<ApartmentDetail> getLstApartmentDetails() {
        return lstApartmentDetails;
    }

    public void setLstApartmentDetails(List<ApartmentDetail> lstApartmentDetails) {
        this.lstApartmentDetails = lstApartmentDetails;
    }
}
