package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.OrtherBill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Service.ServiceImp.BillServiceImp;
import com.example.departmentmanagementproject.Service.ServiceImp.OrtherBillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/ortherbills")
public class OrtherBillController {
    @Autowired
    private OrtherBillServiceImp ortherBillServiceImp;

    @GetMapping("/find/")
    List<OrtherBill> getAllOrtherBills(){
        return ortherBillServiceImp.getAllOrtherBills();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return ortherBillServiceImp.getOrtherBillById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertOrtherBill(@RequestBody OrtherBill newOrtherBill){
        return ortherBillServiceImp.saveOrtherBill(newOrtherBill);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateOrtherBill(@RequestBody OrtherBill newOrtherBill,@PathVariable int id ){
        return ortherBillServiceImp.updateOrtherBillById(newOrtherBill,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteOrtherBill(@PathVariable int id){
        return ortherBillServiceImp.removeOrtherBillById(id);
    }
}
