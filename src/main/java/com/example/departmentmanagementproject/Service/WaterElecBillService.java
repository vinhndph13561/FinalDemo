package com.example.departmentmanagementproject.Service;

import com.example.departmentmanagementproject.Model.Resident;
import com.example.departmentmanagementproject.Model.ResponseObject;
import com.example.departmentmanagementproject.Model.WaterElectricBill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WaterElecBillService {
    List<WaterElectricBill> getAllWaterElectricBills();
    ResponseEntity<ResponseObject> getWaterElectricBillById(int id);
    ResponseEntity<ResponseObject> removeWaterElectricBillById(int id);
    ResponseEntity<ResponseObject> updateWaterElectricBillById(WaterElectricBill newWaterElectricBill, int id);
    ResponseEntity<ResponseObject> saveWaterElectricBill(WaterElectricBill newWaterElectricBill);
}
