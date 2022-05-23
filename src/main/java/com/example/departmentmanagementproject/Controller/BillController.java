package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Service.ServiceImp.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/bills")
public class BillController {
    @Autowired
    private BillServiceImp billServiceImp;

    @GetMapping("/find/")
    List<Bill> getAllApartments(){
        return billServiceImp.getAllBills();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return billServiceImp.getBillById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertBill(@RequestBody Bill newBill){
        return billServiceImp.saveBill(newBill);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateBill(@RequestBody Bill newBill,@PathVariable int id ){
        return billServiceImp.updateBillById(newBill,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteBill(@PathVariable int id){
        return billServiceImp.removeBillById(id);
    }
}
