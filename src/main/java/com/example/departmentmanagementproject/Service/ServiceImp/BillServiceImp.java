package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Repository.BillRepository;
import com.example.departmentmanagementproject.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImp implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getBillById(int id) {
        Optional<Bill> foundBill = billRepository.findById(id);
        if (foundBill.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundBill)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeBillById(int id) {
        boolean existBill = billRepository.existsById(id);
        if (existBill){
            billRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find user","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateBillById(Bill newBill, int id) {
        Bill updateBill = billRepository.findById(id).map(bill ->{
            bill.setOrtherBill(newBill.getOrtherBill());
            bill.setApartment(newBill.getApartment());
            bill.setTotalFee(newBill.getTotalFee());
            bill.setPaymentStatus(newBill.isPaymentStatus());
            return billRepository.save(bill);
        }).orElseGet(() ->{
            newBill.setBillId(id);
            return billRepository.save(newBill);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateBill)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveBill(Bill newBill) {
        Bill foundBill = billRepository.findBillByApartmentIdAndMonth(newBill.getApartment().getApartmentId());
        if (foundBill!=null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","Bill already created","")
            );
        }
        Bill bill = new Bill();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",billRepository.save(newBill))
        );
    }
}
