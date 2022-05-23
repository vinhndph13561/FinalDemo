package com.example.departmentmanagementproject.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "we_bill")
public class WaterElectricBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "we_bill_id")
    private int weBillId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="apartment_id")
    private Apartment apartment;

    private double previousWaterNumber;

    private double currentWaterNumber;

    private double previousElecNumber;

    private double currentElecNummber;

    private double electricPrice;

    private double waterPrice;

    private double usedWaterNumber;

    private double usedElecNumber;

    private double waterFee;

    private double elecFee;

    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updateDate;

    public WaterElectricBill(){

    }

    public WaterElectricBill(Apartment apartment, double previousWaterNumber,
                             double currentWaterNumber, double previousElecNumber,
                             double currentElecNummber, double electricPrice,
                             double waterPrice, double waterFee, double elecFee) {
        this.apartment = apartment;
        this.previousWaterNumber = previousWaterNumber;
        this.currentWaterNumber = currentWaterNumber;
        this.previousElecNumber = previousElecNumber;
        this.currentElecNummber = currentElecNummber;
        this.electricPrice = electricPrice;
        this.waterPrice = waterPrice;

    }

    public int getWeBillId() {
        return weBillId;
    }

    public void setWeBillId(int weBillId) {
        this.weBillId = weBillId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public double getPreviousWaterNumber() {
        return previousWaterNumber;
    }

    public void setPreviousWaterNumber(double previousWaterNumber) {
        this.previousWaterNumber = previousWaterNumber;
    }

    public double getCurrentWaterNumber() {
        return currentWaterNumber;
    }

    public void setCurrentWaterNumber(double currentWaterNumber) {
        this.currentWaterNumber = currentWaterNumber;
    }

    public double getPreviousElecNumber() {
        return previousElecNumber;
    }

    public void setPreviousElecNumber(double previousElecNumber) {
        this.previousElecNumber = previousElecNumber;
    }

    public double getCurrentElecNummber() {
        return currentElecNummber;
    }

    public void setCurrentElecNummber(double currentElecNummber) {
        this.currentElecNummber = currentElecNummber;
    }

    public double getElectricPrice() {
        return electricPrice;
    }

    public void setElectricPrice(double electricPrice) {
        this.electricPrice = electricPrice;
    }

    public double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public double getUsedWaterNumber() {
        return usedWaterNumber=getCurrentWaterNumber()-getPreviousWaterNumber();
    }

    public void setUsedWaterNumber(double usedWaterNumber) {
        this.usedWaterNumber = usedWaterNumber;
    }

    public double getUsedElecNumber() {
        return usedElecNumber=getCurrentElecNummber()-getPreviousElecNumber();
    }

    public void setUsedElecNumber(double usedElecNumber) {
        this.usedElecNumber = usedElecNumber;
    }

    public double getWaterFee() {
        return waterFee  =getUsedWaterNumber()*getWaterPrice();
    }

    public void setWaterFee(double waterFee) {
        this.waterFee = waterFee;
    }

    public double getElecFee() {
        return elecFee=getElectricPrice()*getUsedElecNumber();
    }

    public void setElecFee(double elecFee) {
        this.elecFee = elecFee;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
