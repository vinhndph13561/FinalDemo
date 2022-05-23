package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.ApartmentDetail;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Repository.ApartmentDetailRepository;
import com.example.departmentmanagementproject.Service.ApartmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentDetailServiceImp implements ApartmentDetailService {
    @Autowired
    private ApartmentDetailRepository apartmentDetailRepository;

    @Override
    public List<ApartmentDetail> getAllApartmentDetails() {
        return apartmentDetailRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getApartmentDetailById(int id) {
        Optional<ApartmentDetail> foundApartmentDetail = apartmentDetailRepository.findById(id);
        if (foundApartmentDetail.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundApartmentDetail)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeApartmentDetailById(int id) {
        boolean existAD = apartmentDetailRepository.existsById(id);
        if (existAD){
            apartmentDetailRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find user","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateApartmentDetailById(ApartmentDetail newApartmentDetail, int id) {
        ApartmentDetail updateApartmentDetail = apartmentDetailRepository.findById(id).map(apartmentDetail ->{
            apartmentDetail.setResident(newApartmentDetail.getResident());
            apartmentDetail.setDelete(newApartmentDetail.isDelete());
            apartmentDetail.setApartment(newApartmentDetail.getApartment());
            return apartmentDetailRepository.save(apartmentDetail);
        }).orElseGet(() ->{
            newApartmentDetail.setAdId(id);
            return apartmentDetailRepository.save(newApartmentDetail);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateApartmentDetail)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveApartmentDetail(ApartmentDetail newApartmentDetail) {
        ApartmentDetail foundApartmentDetail = apartmentDetailRepository.findApartmentDetailByApartment_ApartmentIdAndResident_ResidentId(newApartmentDetail.getApartment().getApartmentId(),newApartmentDetail.getResident().getResidentId());
        if (foundApartmentDetail!=null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","ApartmentDetail already created","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",apartmentDetailRepository.save(newApartmentDetail))
        );
    }
}
