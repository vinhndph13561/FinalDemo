package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Integer> {
    Resident findResidentByIDNumber(String idNumber);
}
