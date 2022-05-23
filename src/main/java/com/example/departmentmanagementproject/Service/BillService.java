package com.example.departmentmanagementproject.Service;


import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BillService{
    List<Bill> getAllBills();
    ResponseEntity<ResponseObject> getBillById(int id);
    ResponseEntity<ResponseObject> removeBillById(int id);
    ResponseEntity<ResponseObject> updateBillById(Bill newBill, int id);
    ResponseEntity<ResponseObject> saveBill(Bill newBill);
}
