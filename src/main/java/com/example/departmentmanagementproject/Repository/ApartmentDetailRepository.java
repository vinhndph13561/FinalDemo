package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.ApartmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentDetailRepository extends JpaRepository<ApartmentDetail,Integer> {
    ApartmentDetail findApartmentDetailByApartment_ApartmentIdAndResident_ResidentId(int apartmentId,int residentId);
}
