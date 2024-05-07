package com.haullog.haullog.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haullog.haullog.models.Shipments;
import com.haullog.haullog.repository.ShipmentsRepository;

@Service
public class ShipmentsServiceImplementation implements ShipmentsService{
	
	@Autowired
    private final ShipmentsRepository shipmentsRepository;
	
	public ShipmentsServiceImplementation(ShipmentsRepository shipmentsRepository) {
		this.shipmentsRepository = shipmentsRepository;
	}
	
	@Override
	public ArrayList<Shipments> getShipmentsByMonthYear(int month, int year) {
		Optional<ArrayList<Shipments>> shipments =  shipmentsRepository.findShipmentsByMonthAndYear(month, year);
		
		if(shipments.isPresent())
			return shipments.get();

		return new ArrayList<Shipments> ();
	}
}