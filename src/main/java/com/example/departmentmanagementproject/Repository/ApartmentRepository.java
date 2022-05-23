package com.example.departmentmanagementproject.Repository;

import com.example.departmentmanagementproject.Model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment,Integer> {
    Apartment findApartmentByFloorAndRoomNumber(int floor,int roomNumBer);

}
