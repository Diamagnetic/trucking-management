package com.haullog.haullog.service;

import java.util.List;

import com.haullog.haullog.models.Shipments;

public interface ShipmentsService {
	List<Shipments> getShipmentsByMonthYear(int month, int year);
}
