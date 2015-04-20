package org.pahospital.www.transportationservice;

import java.util.Calendar;

public class Patient {
	private String patientID;
	private String requestingUnit;
	private String destinationUnit;
	private Calendar transportationDate;

	public Patient() {
	}

	public Patient(String patientID, String requestingUnit,
			String destinationUnit, Calendar transportationDate) {
		super();
		this.patientID = patientID;
		this.requestingUnit = requestingUnit;
		this.destinationUnit = destinationUnit;
		this.transportationDate = transportationDate;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getRequestingUnit() {
		return requestingUnit;
	}

	public void setRequestingUnit(String requestingUnit) {
		this.requestingUnit = requestingUnit;
	}

	public String getDestinationUnit() {
		return destinationUnit;
	}

	public void setDestinationUnit(String destinationUnit) {
		this.destinationUnit = destinationUnit;
	}

	public Calendar getTransportationDate() {
		return transportationDate;
	}

	public void setTransportationDate(Calendar transportationDate) {
		this.transportationDate = transportationDate;
	}
	
	
}
