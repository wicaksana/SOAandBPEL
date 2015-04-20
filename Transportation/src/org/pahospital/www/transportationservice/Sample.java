package org.pahospital.www.transportationservice;

public class Sample {
	private String patientID;
	private String requestingUnit;
	private String sampleID;

	public Sample() {
	}

	public Sample(String patientID, String requestingUnit, String sampleID) {
		this.patientID = patientID;
		this.requestingUnit = requestingUnit;
		this.sampleID = sampleID;
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

	public String getSampleID() {
		return sampleID;
	}

	public void setSampleID(String sampleID) {
		this.sampleID = sampleID;
	}
	
	
}
