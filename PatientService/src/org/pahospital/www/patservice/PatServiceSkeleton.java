
/**
 * PatServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.pahospital.www.patservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
	/**
     *  PatServiceSkeleton java skeleton for the axisService
     */

public class PatServiceSkeleton {

	private static Integer patientID = 0; 
	static ArrayList<Patient> patientDB = new ArrayList<Patient>();
	static ArrayList<RadiologyReport> radiologyReportDB = new ArrayList<RadiologyReport>();
	static ArrayList<LabReport> labReportDB = new ArrayList<LabReport>();
	
	//default patient: null
	static Patient nullPatient = new Patient();
	static LabReport nullLabReport = new LabReport();
	static RadiologyReport nullRadReport = new RadiologyReport();
	
	public PatServiceSkeleton() {
		
		//testing purpose
		Patient arif = new Patient();
		arif.setPatientName("arif");
		arif.setPatientID("100");
		arif.setPatientStreet("haaksbergerstraat");
		arif.setPatientZipCode(7513);
		arif.setPatientCity("Enschede");
		arif.setPatientBirthday(new Date());
		
		patientDB.add(arif);
	}
	
		/**
         * send radiology report to client based on the patient ID and radiology order ID
         * 
         * @param radiologyReportOrder 
         * @return radiologyReport 
         */
        
	public org.pahospital.www.patservice.RadiologyReport retrieveRadiologyReport(
			org.pahospital.www.patservice.RadiologyReportOrder radiologyReportOrder) {
		
		System.out.println("***********************************");
		System.out.println(" retrieveRadiologyReport() called");
		System.out.println("***********************************");
		
		for(RadiologyReport report: radiologyReportDB) {
			if(report.getPatientID().equals(radiologyReportOrder.getPatientID()) &&
					report.getRadiologyOrderID().equals(radiologyReportOrder.getRadiologyOrderID()))
				return report;
		}
		
		setDefaultRadReport(nullRadReport);
		return nullRadReport;
	}
     
         
        private void setDefaultRadReport(RadiologyReport nullRadReport2) {
			nullRadReport2.setPatientID("-1");	
			nullRadReport2.setRadiologyOrderID("-1");
			nullRadReport2.setDateOfExamination(new Date());
			nullRadReport2.setReportText("");
		}

		/**
         * store lab report into the 'database' (labReportDB)
         * 
         * @param labReport 
         * @return  
         */
        
	public void storeLabReport(org.pahospital.www.patservice.LabReport labReport) {
		
		System.out.println("***********************************");
		System.out.println(" storeLabReport() called");
		System.out.println("***********************************");
		
		labReportDB.add(labReport);
                
	}
     
         
        /**
         * create new patient record in the 'database' (patientDB)
         * 
         * @param patient 
         * @return patientID 
         */
        
	public org.pahospital.www.patservice.PatientID createPatientRecord(org.pahospital.www.patservice.Patient patient) {
		
		System.out.println("***********************************");
		System.out.println(" createPatientReport() called");
		System.out.println("***********************************");
		
		PatientID returnedPatientID = new PatientID();
		
		patient.setPatientID(patientID.toString());
		patientDB.add(patient);
		patientID++;
		
		//return the patient ID
		returnedPatientID.setPatientID(patient.getPatientID());
		return returnedPatientID;
	}
     
         
        /**
         * Return patient ID based on the given name
         * 
         * @param patientName 
         * @return iDsList 
         */
        
	public org.pahospital.www.patservice.IDsList getPatientIDsByName(org.pahospital.www.patservice.PatientName patientName) {

		System.out.println("***********************************");
		System.out.println(" getPatientIDsByName() called");
		System.out.println("***********************************");
		
		IDsList returnedIDsList = new IDsList();
		

		for(Patient p: patientDB) {
			if(p.getPatientName().equals(patientName.getPatientName()))
				returnedIDsList.addPatientID(p.getPatientID());
		}
		
		return returnedIDsList;
	}
     
         
        /**
         * return patient data based on the given patient ID
         * 
         * @param patientID0 
         * @return patient1 
         */
        
	public org.pahospital.www.patservice.Patient getPatientByID(org.pahospital.www.patservice.PatientID patientID0) {
		
		System.out.println("***********************************");
		System.out.println(" getPatientByID() called");
		System.out.println("***********************************");
		
		for(Patient p: patientDB) {
			if(p.getPatientID().equals(patientID0.getPatientID())) {
				return p;
			}
		}
		setDefaultPatient(nullPatient);
		return nullPatient;
		
	}
     
         
        private void setDefaultPatient(Patient nullPatient2) {
			nullPatient2.setPatientID("-1");
			nullPatient2.setPatientBirthday(new Date());
			nullPatient2.setPatientCity("");
			nullPatient2.setPatientName("");
			nullPatient2.setPatientStreet("");
			nullPatient2.setPatientZipCode(-1);
		}

		/**
         * send lab report to the client, based on the given lab report order
         * 
         * @param labReportOrder 
         * @return labReport2 
         */
        
	public org.pahospital.www.patservice.LabReport retrieveLabReport(
			org.pahospital.www.patservice.LabReportOrder labReportOrder) {

		System.out.println("***********************************");
		System.out.println(" retrieveLabReport() called");
		System.out.println("***********************************");
		
		for(LabReport labReport: labReportDB) {
			if(labReport.getPatientID().equals(labReportOrder.getPatientID()) &&
					labReport.getLabOrderID().equals(labReportOrder.getLabOrderID()))
				return labReport;
		}
		setDefaultLabReport(nullLabReport);		
		return nullLabReport;		
	}
     
         
        private void setDefaultLabReport(LabReport nullLabReport2) {
        	LabValues_type0[] labValues = new LabValues_type0[1];
			nullLabReport2.setLabOrderID("-1");
			nullLabReport2.setPatientID("-1");
			nullLabReport2.setSampleID("-1");
			nullLabReport2.setLabValues(labValues);
		}

		/**
         * store radiology report sent by client to the 'database' (radiologyReportDB) 
         * 
         * @param radiologyReport3 
         * @return  
         */
        
	public void storeRadiologyReport(org.pahospital.www.patservice.RadiologyReport radiologyReport3) {

		System.out.println("***********************************");
		System.out.println(" storeRadiologyReport() called");
		System.out.println("***********************************");
		
		radiologyReportDB.add(radiologyReport3);
		
	}
     
}
    