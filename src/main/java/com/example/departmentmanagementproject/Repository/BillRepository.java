package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    @Query("SELECT b FROM Bill b WHERE b.apartment.apartmentId = ?1 and b.paymentStatus=false ")
    Bill findBillByApartmentIdAndMonth(int apartmentId);
}
