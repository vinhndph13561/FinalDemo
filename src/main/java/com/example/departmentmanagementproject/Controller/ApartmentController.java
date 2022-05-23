package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Service.ServiceImp.ApartmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/apartments")
public class ApartmentController {
    @Autowired
    private ApartmentServiceImp apartmentServiceImp;

    @GetMapping("/find/")
    List<Apartment> getAllApartments(){
        return apartmentServiceImp.getAllApartments();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return apartmentServiceImp.getApartmentById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertApartment(@RequestBody Apartment newApartment){
        return apartmentServiceImp.saveApartment(newApartment);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateApartment(@RequestBody Apartment newApartment,@PathVariable int id ){
        return apartmentServiceImp.updateApartmentById(newApartment,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteApartment(@PathVariable int id){
        return apartmentServiceImp.removeApartmentById(id);
    }
}
