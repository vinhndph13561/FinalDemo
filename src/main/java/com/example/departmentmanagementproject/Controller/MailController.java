package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Repository.ApartmentRepository;
import com.example.departmentmanagementproject.Repository.BillRepository;
import com.example.departmentmanagementproject.SbMail.MailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Controller
public class MailController {
    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
        Date date = new Date();
        System.out.println(date);
        List<Apartment> apartments = apartmentRepository.findAll();
        System.out.println(apartments.get(0).getApartmentId());
        Map<String,Bill> billMap = new TreeMap<>();
        for (Apartment apart: apartments) {
            billMap.put(apart.getOwner().getEmail(),billRepository.findBillByApartmentIdAndMonth(apart.getApartmentId()));
            System.out.println(billRepository.findBillByApartmentIdAndMonth(1));
        }

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        for (Map.Entry<String, Bill> entry : billMap.entrySet()) {
            message.setTo(entry.getKey());
            message.setSubject("Room "+entry.getValue().getApartment().getFloor()+entry.getValue().getApartment().getRoomNumber()+" 's Bill");
            message.setText("Electric number: "+entry.getValue().getApartment().getWaterElectricBill().getUsedElecNumber()+"\n"+
                            "Electric price:  "+entry.getValue().getApartment().getWaterElectricBill().getElectricPrice()+" VND\n"+
                            "Water number:    "+entry.getValue().getApartment().getWaterElectricBill().getUsedWaterNumber()+"\n"+
                            "Water price:     "+entry.getValue().getApartment().getWaterElectricBill().getWaterPrice()+" VND \n"+
                            "Other fee:       "+entry.getValue().getOrtherBill().getOrtherFee()+" VND \n"+
                            "Total:           "+entry.getValue().getTotalFee()+" VND"
                            );
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }
}
