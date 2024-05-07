package com.haullog.haullog.services;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.haullog.haullog.models.Shipments;
import com.haullog.haullog.repository.ShipmentsRepository;

@SpringBootTest
public class ShipmentsServiceImplementation {
	
	@Mock
	@Autowired
    private ShipmentsRepository shipmentsRepository;
	
	@BeforeMethod
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
    }
	
	@Test
	public void testShipmentsDataRetrieval() {
		
		Optional<List<Shipments>> s = shipmentsRepository.findShipmentsByMonthAndYear(05, 2024);
		
		System.out.println(s.get().size());
	}
}
