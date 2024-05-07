package com.haullog.haullog.service;

import java.util.ArrayList;

import com.haullog.haullog.models.Shipments;

public interface ShipmentsService {
	ArrayList<Shipments> getShipmentsByMonthYear(int month, int year);
}
