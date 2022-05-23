package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Repository.ApartmentRepository;
import com.example.departmentmanagementproject.Service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImp implements ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getApartmentById(int id) {
        Optional<Apartment> foundApartment = apartmentRepository.findById(id);
        if (foundApartment.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundApartment)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeApartmentById(int id) {
        boolean exist = apartmentRepository.existsById(id);
        if (exist){
            apartmentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find user","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateApartmentById(Apartment newApartment, int id) {
        Apartment updateApart = apartmentRepository.findById(id).map(apartment ->{
            apartment.setFloor(newApartment.getFloor());
            apartment.setRoomNumber(newApartment.getRoomNumber());
            apartment.setSquare(newApartment.getSquare());
            apartment.setRoomQuantity(newApartment.getRoomQuantity());
            apartment.setPrice(newApartment.getPrice());
            apartment.setLstApartmentDetails(newApartment.getLstApartmentDetails());
            return apartmentRepository.save(apartment);
        }).orElseGet(() ->{
            newApartment.setApartmentId(id);
            return apartmentRepository.save(newApartment);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateApart)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveApartment(Apartment newApartment) {
        Apartment foundApartment = apartmentRepository.findApartmentByFloorAndRoomNumber(newApartment.getFloor(),newApartment.getRoomNumber());
        if (foundApartment!=null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","Apartment already created","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",apartmentRepository.save(newApartment))
        );
    }
}
