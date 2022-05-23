package com.example.departmentmanagementproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="apartment_detail")
public class ApartmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_id", nullable = false)
    private int adId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="apartment_id")
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resident_id")
    private Resident resident;

    private boolean delete;

    public ApartmentDetail(){}

    public ApartmentDetail(Apartment apartment, Resident resident, boolean delete) {
        this.apartment = apartment;
        this.resident = resident;
        this.delete = delete;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
