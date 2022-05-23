package com.example.departmentmanagementproject.Service;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getAllApartments();
    ResponseEntity<ResponseObject> getApartmentById(int id);
    ResponseEntity<ResponseObject> removeApartmentById(int id);
    ResponseEntity<ResponseObject> updateApartmentById(Apartment newApartment, int id);
    ResponseEntity<ResponseObject> saveApartment(Apartment newApartment);
}
