package com.haullog.haullog.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haullog.haullog.models.Shipments;

@Repository
public interface ShipmentsRepository extends JpaRepository<Shipments, Long> {
	
	@Query("SELECT s FROM shipments s WHERE YEAR(s.shipment_date) = :year AND MONTH(s.shipment_date) = :month")
    Optional<ArrayList<Shipments>> findShipmentsByMonthAndYear(int month, int year);
}