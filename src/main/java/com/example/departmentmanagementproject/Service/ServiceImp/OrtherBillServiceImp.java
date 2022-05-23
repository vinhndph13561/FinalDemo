package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Bill;
import com.example.departmentmanagementproject.Model.OrtherBill;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Repository.OrtherBillRepository;
import com.example.departmentmanagementproject.Service.OrtherBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrtherBillServiceImp implements OrtherBillService {
    @Autowired
    private OrtherBillRepository ortherBillRepository;

    @Override
    public List<OrtherBill> getAllOrtherBills() {
        return ortherBillRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getOrtherBillById(int id) {
        Optional<OrtherBill> foundOrtherBill = ortherBillRepository.findById(id);
        if (foundOrtherBill.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundOrtherBill)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeOrtherBillById(int id) {
        boolean existOrtherBill = ortherBillRepository.existsById(id);
        if (existOrtherBill){
            ortherBillRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find id","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateOrtherBillById(OrtherBill newOrtherBill, int id) {
        OrtherBill updateOrtherBill = ortherBillRepository.findById(id).map(ortherBill  ->{
            ortherBill.setCleaningFee(newOrtherBill.getCleaningFee());
            ortherBill.setElevatorFee(newOrtherBill.getElevatorFee());
            ortherBill.setParkingFee(newOrtherBill.getParkingFee());
            ortherBill.setOrtherFee(newOrtherBill.getOrtherFee());
            return ortherBillRepository.save(ortherBill);
        }).orElseGet(() ->{
            newOrtherBill.setOtherBillId(id);
            return ortherBillRepository.save(newOrtherBill);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateOrtherBill)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveOrtherBill(OrtherBill newOrtherBill) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",ortherBillRepository.save(newOrtherBill))
        );
    }
}
