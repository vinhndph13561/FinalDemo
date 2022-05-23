package com.example.departmentmanagementproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id", nullable = false)
    private int apartmentId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="we_bill_id")
    private WaterElectricBill waterElectricBill;

    private int floor;

    private int roomNumber;

    private double square;

    private int roomQuantity;

    private double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="resident_id")
    private Resident owner;

    @JsonIgnore
    @OneToMany(mappedBy = "apartment")
    List<ApartmentDetail> lstApartmentDetails;

    public Apartment(){}

    public Apartment(WaterElectricBill waterElectricBill, int floor, int roomNumber, double square, int roomQuantity,
                     double price, Resident owner, List<ApartmentDetail> lstApartmentDetails) {
        this.waterElectricBill= waterElectricBill;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.square = square;
        this.roomQuantity = roomQuantity;
        this.price = price;
        this.owner = owner;
        this.lstApartmentDetails = lstApartmentDetails;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public WaterElectricBill getWaterElectricBill() {
        return waterElectricBill;
    }

    public void setWaterElectricBill(WaterElectricBill waterElectricBill) {
        this.waterElectricBill = waterElectricBill;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Resident getOwner() {
        return owner;
    }

    public void setOwner(Resident owner) {
        this.owner = owner;
    }

    public List<ApartmentDetail> getLstApartmentDetails() {
        return lstApartmentDetails;
    }

    public void setLstApartmentDetails(List<ApartmentDetail> lstApartmentDetails) {
        this.lstApartmentDetails = lstApartmentDetails;
    }
}
