package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Model.WaterElectricBill;
import com.example.departmentmanagementproject.Service.ServiceImp.WaterElectricBillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/webills")
public class WEBillController {
    @Autowired
    private WaterElectricBillServiceImp waterElectricBillServiceImp;

    @GetMapping("/find/")
    List<WaterElectricBill> getAllWaterElectricBills(){
        return waterElectricBillServiceImp.getAllWaterElectricBills();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return waterElectricBillServiceImp.getWaterElectricBillById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertWaterElectricBill(@RequestBody WaterElectricBill newWaterElectricBill){
        return waterElectricBillServiceImp.saveWaterElectricBill(newWaterElectricBill);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateWaterElectricBill(@RequestBody WaterElectricBill newWaterElectricBill,@PathVariable int id ){
        return waterElectricBillServiceImp.updateWaterElectricBillById(newWaterElectricBill,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteWaterElectricBill(@PathVariable int id){
        return waterElectricBillServiceImp.removeWaterElectricBillById(id);
    }
}
