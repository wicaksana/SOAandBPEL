
/**
 * TransportationServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.pahospital.www.transportationservice;

import java.util.ArrayList;

    /**
     *  TransportationServiceSkeleton java skeleton for the axisService
     */

public class TransportationServiceSkeleton{
	private static ArrayList<PatientOrder> transportPatientDB = new ArrayList<PatientOrder>();
	private static ArrayList<SampleOrder> transportSamplesDB = new ArrayList<SampleOrder>(); 

	
	
	public TransportationServiceSkeleton() {

	}


	/**
      * order transporting patient
      * 
      * @param patientOrder 
      * @return  
      */
        
	public void orderPatientTransport(org.pahospital.www.transportationservice.PatientOrder patientOrder) {
		
		transportPatientDB.add(patientOrder);
		
		System.out.println("New object created:\n " +
				"\tPatient id: " + transportPatientDB.get(transportPatientDB.size()-1).getPatientID() + "\n" +
				"\n\tRequesting unit: " + transportPatientDB.get(transportPatientDB.size()-1).getRequestingUnit() + "\n" +
				"\n\tDestination unit: " + transportPatientDB.get(transportPatientDB.size()-1).getDestinationUnit() + "\n" +
				"\n\tTransportation date: " + transportPatientDB.get(transportPatientDB.size()-1).getTransportationDate().toString()
				);
	}
     
         
        /**
         * order transporting sample
         * 
         * @param sampleOrder 
         * @return  
         */
        
	public void orderSampleTransport(org.pahospital.www.transportationservice.SampleOrder sampleOrder){
		
		transportSamplesDB.add(sampleOrder);

		System.out.println("New object created:\n " +
				"\tPatient id: " + transportSamplesDB.get(transportSamplesDB.size()-1).getPatientID() + "\n" +
				"\n\tRequesting unit: " + transportSamplesDB.get(transportSamplesDB.size()-1).getRequestingUnit() + "\n" +
				"\n\tSample id: " + transportSamplesDB.get(transportSamplesDB.size()-1).getSampleID() + "\n" 
				);
		
	}
     
}
    