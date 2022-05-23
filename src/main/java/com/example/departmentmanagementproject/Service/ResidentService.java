package com.example.departmentmanagementproject.Service;


import com.example.departmentmanagementproject.Model.Resident;
import com.example.departmentmanagementproject.Model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ResidentService {
    List<Resident> getAllResidents();
    ResponseEntity<ResponseObject> getResidentById(int id);
    ResponseEntity<ResponseObject> removeResidentById(int id);
    ResponseEntity<ResponseObject> updateResidentById(Resident newResident, int id);
    ResponseEntity<ResponseObject> saveResident(Resident newResident);
}
