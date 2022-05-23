package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.WaterElectricBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterElecBillRepository extends JpaRepository<WaterElectricBill,Integer> {
    WaterElectricBill findWaterElectricBillByApartmentApartmentId(int apartId);
}
