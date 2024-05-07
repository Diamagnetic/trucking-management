package com.haullog.haullog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haullog.haullog.models.Shipments;

@Repository
public interface ShipmentsRepository extends CrudRepository<Shipments, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM shipments WHERE EXTRACT(YEAR FROM shipment_date) = :year AND EXTRACT(MONTH FROM shipment_date) = :month")// WHERE EXTRACT(YEAR FROM s.shipment_date) = :year AND EXTRACT(MONTH FROM s.shipment_date) = :month;")
    Optional<List<Shipments>> findShipmentsByMonthAndYear(@Param("month") int month, @Param("year") int year);
}