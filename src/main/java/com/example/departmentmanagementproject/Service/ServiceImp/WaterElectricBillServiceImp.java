package com.example.departmentmanagementproject.Service.ServiceImp;

import com.example.departmentmanagementproject.Model.Resident;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Model.WaterElectricBill;
import com.example.departmentmanagementproject.Repository.ResidentRepository;
import com.example.departmentmanagementproject.Repository.WaterElecBillRepository;
import com.example.departmentmanagementproject.Service.WaterElecBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaterElectricBillServiceImp implements WaterElecBillService {
    @Autowired
    private WaterElecBillRepository waterElecBillRepository;

    @Override
    public List<WaterElectricBill> getAllWaterElectricBills() {
        return waterElecBillRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> getWaterElectricBillById(int id) {
        Optional<WaterElectricBill> foundWaterElectricBill = waterElecBillRepository.findById(id);
        if (foundWaterElectricBill.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("oke","successfully",foundWaterElectricBill)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("oke","Can not find id" +id, "")
            );
        }
    }

    @Override
    public ResponseEntity<ResponseObject> removeWaterElectricBillById(int id) {
        boolean existWaterElectricBill = waterElecBillRepository.existsById(id);
        if (existWaterElectricBill){
            waterElecBillRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","success","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not find user","")
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateWaterElectricBillById(WaterElectricBill newWaterElectricBill, int id) {
        WaterElectricBill updateWaterElectricBill = waterElecBillRepository.findById(id).map(waterElectricBill ->{
            waterElectricBill.setApartment(newWaterElectricBill.getApartment());
            waterElectricBill.setPreviousWaterNumber(newWaterElectricBill.getPreviousWaterNumber());
            waterElectricBill.setCurrentWaterNumber(newWaterElectricBill.getCurrentWaterNumber());
            waterElectricBill.setWaterPrice(newWaterElectricBill.getWaterPrice());
            waterElectricBill.setPreviousElecNumber(newWaterElectricBill.getPreviousElecNumber());
            waterElectricBill.setCurrentElecNummber(newWaterElectricBill.getCurrentElecNummber());
            waterElectricBill.setElectricPrice(newWaterElectricBill.getElectricPrice());
            waterElectricBill.setWaterFee(newWaterElectricBill.getWaterFee());
            waterElectricBill.setElecFee(newWaterElectricBill.getElecFee());
            waterElectricBill.setUsedElecNumber(newWaterElectricBill.getUsedElecNumber());
            waterElectricBill.setUsedWaterNumber(newWaterElectricBill.getUsedWaterNumber());
            return waterElecBillRepository.save(waterElectricBill);
        }).orElseGet(() ->{
            newWaterElectricBill.setWeBillId(id);
            return waterElecBillRepository.save(newWaterElectricBill);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",updateWaterElectricBill)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> saveWaterElectricBill(WaterElectricBill waterElectricBill) {
        WaterElectricBill foundWaterElectricBill = waterElecBillRepository.findWaterElectricBillByApartmentApartmentId(waterElectricBill.getApartment().getApartmentId());
        if (foundWaterElectricBill!=null){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed","WaterElectricBill already created","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","success",waterElecBillRepository.save(waterElectricBill))
        );
    }
}
