package com.example.departmentmanagementproject.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id", nullable = false)
    private int billId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id", referencedColumnName = "apartment_id")
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "otherbill_id", referencedColumnName = "ortherbill_id")
    private OrtherBill ortherBill;

    private double totalFee;

    private Date paymentDate;

    private boolean paymentStatus;

    public Bill(){}

    public Bill(Apartment apartment, OrtherBill ortherBill,
                double totalFee, boolean paymentStatus) {
        this.apartment = apartment;
        this.ortherBill = ortherBill;
        this.totalFee = totalFee;
        this.paymentStatus = paymentStatus;
        this.paymentDate = new Date();
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public OrtherBill getOrtherBill() {
        return ortherBill;
    }

    public void setOrtherBill(OrtherBill ortherBill) {
        this.ortherBill = ortherBill;
    }

    public double getTotalFee() {
        return (totalFee = (getApartment().getWaterElectricBill().getElecFee()) + (getApartment().getWaterElectricBill().getWaterFee()) + getOrtherBill().getOrtherFee());
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate() {
        this.paymentDate = new Date();
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
