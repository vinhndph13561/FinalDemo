package com.example.departmentmanagementproject.Service;

import com.example.departmentmanagementproject.Model.Apartment;
import com.example.departmentmanagementproject.Repository.ApartmentRepository;
import com.example.departmentmanagementproject.Service.ServiceImp.ApartmentServiceImp;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApartmentServiceTest {
    @Mock
    ApartmentRepository apartmentRepository;

    @InjectMocks
    ApartmentServiceImp apartmentServiceImp;

    @Test
    public void getAllApartmentTest() {
        List<Apartment> apartments = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            apartments.add(new Apartment((int)i));
        }

        when(apartmentRepository.findAll()).thenReturn(apartments);

        List<Apartment> list = apartmentServiceImp.getAllApartments();

        assertEquals(2, apartments.size());
        verify(apartmentRepository, times(1)).findAll();
    }
}
