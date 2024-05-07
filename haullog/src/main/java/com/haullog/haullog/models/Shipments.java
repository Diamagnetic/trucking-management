package com.haullog.haullog.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipments {
	
	private enum ShipmentStatus {
		Delivered("Delivered"),
		InTransit("In Transit"),
		Pending("Pending"),
		Incomplete("Incomplete"),
		PaymentPending("Payment Pending"),
		None("None");
		
		private final String displayName;

		ShipmentStatus(String displayName) {
	        this.displayName = displayName;
	    }

	    public String getDisplayName() {
	        return displayName;
	    }
	    
	    public ShipmentStatus setDisplayName(String shipmentStatus) {
	    	for (ShipmentStatus s : ShipmentStatus.values()) {
	    		if(s.getDisplayName() == shipmentStatus)
	    			return s;
	    	}
	    	
	    	return ShipmentStatus.None;
	    }
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="shipment_id")
	private long shipmentId;

	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="driver_id")
	private long driverId;
	
	@Column(name="truck_id")
	private long truckId;
	
	@Column(name="shipment_cost")
	private long shipmentCost;
	
	@Column(name="shipment_status")
	private ShipmentStatus shipmentStatus;
	
	@Column(name="shipment_created")
	private LocalDate shipmentCreatedDate;
	
	@Column(name="shipment_source")
	private String shipmentSource;
	
	@Column(name="shipment_destination")
	private String shipmentDestination;
	
	@Column(name="creator_id")
	private long creatorId;
	
	public Shipments() {
		
	}
	
	public Shipments(long customerId, long driverId, long truckId, long shipmentCost,
			String shipmentStatus, String shipmentSource, String shipmentDestination, long creatorId) {
		this.customerId = customerId;
		this.driverId = driverId;
		this.truckId = truckId;
		this.shipmentCost = shipmentCost;
		this.shipmentStatus.setDisplayName(shipmentStatus);
		this.shipmentSource = shipmentSource;
		this.shipmentDestination = shipmentDestination;
		this.creatorId = creatorId;
	}
	
	public long getShipmentId() {
		return shipmentId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getDriverId() {
		return driverId;
	}

	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}

	public long getTruckId() {
		return truckId;
	}

	public void setTruckId(long truckId) {
		this.truckId = truckId;
	}

	public long getShipmentCost() {
		return shipmentCost;
	}

	public void setShipmentCost(long shipmentCost) {
		this.shipmentCost = shipmentCost;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipmentSource() {
		return shipmentSource;
	}

	public void setShipmentSource(String shipmentSource) {
		this.shipmentSource = shipmentSource;
	}

	public String getShipmentDestination() {
		return shipmentDestination;
	}

	public void setShipmentDestination(String shipmentDestination) {
		this.shipmentDestination = shipmentDestination;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}
}
