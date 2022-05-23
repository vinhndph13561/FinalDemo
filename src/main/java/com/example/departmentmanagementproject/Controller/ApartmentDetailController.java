package com.example.departmentmanagementproject.Controller;

import com.example.departmentmanagementproject.Model.ApartmentDetail;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Service.ServiceImp.ApartmentDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/controller/apartmentdetails")
public class ApartmentDetailController {
    @Autowired
    private ApartmentDetailServiceImp apartmentDetailServiceImp;

    @GetMapping("/find/")
    List<ApartmentDetail> getAllApartments(){
        return apartmentDetailServiceImp.getAllApartmentDetails();
    }

    @GetMapping("/find/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable int id){
        return apartmentDetailServiceImp.getApartmentDetailById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertApartmentDetail(@RequestBody ApartmentDetail newApartmentDetail){
        return apartmentDetailServiceImp.saveApartmentDetail(newApartmentDetail);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateApartmentDetail(@RequestBody ApartmentDetail newApartmentDetail,@PathVariable int id ){
        return apartmentDetailServiceImp.updateApartmentDetailById(newApartmentDetail,id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject> deleteApartmentDetail(@PathVariable int id){
        return apartmentDetailServiceImp.removeApartmentDetailById(id);
    }
}
