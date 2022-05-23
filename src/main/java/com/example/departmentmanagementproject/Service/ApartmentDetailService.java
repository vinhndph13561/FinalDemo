package com.example.departmentmanagementproject.Service;

import com.example.departmentmanagementproject.Model.ApartmentDetail;
import com.example.departmentmanagementproject.Model.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApartmentDetailService {
    List<ApartmentDetail> getAllApartmentDetails();
    ResponseEntity<ResponseObject> getApartmentDetailById(int id);
    ResponseEntity<ResponseObject> removeApartmentDetailById(int id);
    ResponseEntity<ResponseObject> updateApartmentDetailById(ApartmentDetail newApartmentDetail, int id);
    ResponseEntity<ResponseObject> saveApartmentDetail(ApartmentDetail newApartmentDetail);
}
