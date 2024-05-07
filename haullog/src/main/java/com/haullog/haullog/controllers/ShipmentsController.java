package com.haullog.haullog.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.haullog.haullog.models.Shipments;
import com.haullog.haullog.service.ShipmentsService;

@RestController
public class ShipmentsController {
	private final ShipmentsService shipmentsService;
	
	public ShipmentsController(ShipmentsService shipmentsService) {
		this.shipmentsService = shipmentsService;
	}
	
	@GetMapping("/getShipmentsByDate/{month}/{year}")
	public ResponseEntity<ArrayList<Shipments>> getShipmentsByDate(@PathVariable("month") int month, @PathVariable("year") int year) {
		if(month >= 1 && month <= 12) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Shipments> ());
		}
		ArrayList<Shipments> shipments = shipmentsService.getShipmentsByMonthYear(month, year);
		return ResponseEntity.ok(shipments);
	}
}
