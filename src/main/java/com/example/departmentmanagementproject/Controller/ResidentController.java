package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.Resident;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Service.ServiceImp.BillServiceImp;
import com.example.departmentmanagementproject.Service.ServiceImp.ResidentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/residents")
public class ResidentController {
    @Autowired
    private ResidentServiceImp residentServiceImp;

    @GetMapping("/find/")
    List<Resident> getAllResidents(){
        return residentServiceImp.getAllResidents();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return residentServiceImp.getResidentById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertResident(@RequestBody Resident newResident){
        return residentServiceImp.saveResident(newResident);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateResident(@RequestBody Resident newResident,@PathVariable int id ){
        return residentServiceImp.updateResidentById(newResident,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteResident(@PathVariable int id){
        return residentServiceImp.removeResidentById(id);
    }
}
