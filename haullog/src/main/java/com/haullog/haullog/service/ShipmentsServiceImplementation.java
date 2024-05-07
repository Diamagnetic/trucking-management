package com.haullog.haullog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public List<Shipments> getShipmentsByMonthYear(int month, int year) {

		Optional<List<Shipments>> optionalShipments =  shipmentsRepository.findShipmentsByMonthAndYear(month, year);
		
		if(optionalShipments.isPresent()) {
			List<Shipments> shipments = optionalShipments.get().stream()
				    .map(shipment -> new Shipments(
				    		shipment.getShipmentId(),
				            shipment.getCustomerId(), 
				            shipment.getDriverId(), 
				            shipment.getTruckId(), 
				            shipment.getShipmentCost(), 
				            shipment.getShipmentStatus(),
				            shipment.getShipmentSource(), 
				            shipment.getShipmentDestination(), 
				            shipment.getCreatorId(), 
				            shipment.getShipmentCreatedDate()
				        ))
				        .collect(Collectors.toList());
			
			return shipments;
		}

		return new ArrayList<> ();
	}
}