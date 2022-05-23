package com.example.departmentmanagementproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orther_bill")
public class OrtherBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ortherbill_id", nullable = false)
    private int otherBillId;

    private double cleaningFee;

    private double elevatorFee;

    private double parkingFee;

    private double ortherFee;

    private Date createDate;

    public OrtherBill(){}

    public OrtherBill( double cleaningFee, double elevatorFee, double parkingFee) {

        this.cleaningFee = cleaningFee;
        this.elevatorFee = elevatorFee;
        this.parkingFee = parkingFee;
    }

    public int getOtherBillId() {
        return otherBillId;
    }

    public void setOtherBillId(int otherBillId) {
        this.otherBillId = otherBillId;
    }


    public double getCleaningFee() {
        return cleaningFee;
    }

    public void setCleaningFee(double cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    public double getElevatorFee() {
        return elevatorFee;
    }

    public void setElevatorFee(double elevatorFee) {
        this.elevatorFee = elevatorFee;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public double getOrtherFee() {
        return ortherFee=getCleaningFee()+getElevatorFee()+getParkingFee();
    }

    public void setOrtherFee(double ortherFee) {
        this.ortherFee = ortherFee;
    }
}
