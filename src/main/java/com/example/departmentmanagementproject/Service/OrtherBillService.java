package com.example.departmentmanagementproject.Service;


import com.example.departmentmanagementproject.Model.OrtherBill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrtherBillService {
    List<OrtherBill> getAllOrtherBills();
    ResponseEntity<ResponseObject> getOrtherBillById(int id);
    ResponseEntity<ResponseObject> removeOrtherBillById(int id);
    ResponseEntity<ResponseObject> updateOrtherBillById(OrtherBill newOrtherBill, int id);
    ResponseEntity<ResponseObject> saveOrtherBill(OrtherBill newOrtherBill);
}
