package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.OrtherBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrtherBillRepository extends JpaRepository<OrtherBill,Integer> {
}
