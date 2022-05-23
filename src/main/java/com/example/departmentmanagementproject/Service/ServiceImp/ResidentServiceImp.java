package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.Resident;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Repository.ResidentRepository;
import com.example.departmentmanagementproject.Service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentServiceImp implements ResidentService {
    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getResidentById(int id) {
        Optional<Resident> foundResident = residentRepository.findById(id);
        if (foundResident.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundResident)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeResidentById(int id) {
        boolean existResident = residentRepository.existsById(id);
        if (existResident){
            residentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find user","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateResidentById(Resident newResident, int id) {
        Resident updateResident = residentRepository.findById(id).map(resident ->{
            resident.setEmail(newResident.getEmail());
            resident.setBirthYear(newResident.getBirthYear());
            resident.setGender(newResident.isGender());
            resident.setName(newResident.getName());
            resident.setPhoneNumber(newResident.getPhoneNumber());
            resident.setIDNumber(newResident.getIDNumber());
            resident.setLstApartmentDetails(newResident.getLstApartmentDetails());
            return residentRepository.save(resident);
        }).orElseGet(() ->{
            newResident.setResidentId(id);
            return residentRepository.save(newResident);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateResident)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveResident(Resident newResident) {
        Resident foundResident = residentRepository.findResidentByIDNumber(newResident.getIDNumber());
        if (foundResident!=null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","Resident already created","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",residentRepository.save(newResident))
        );
    }
}
