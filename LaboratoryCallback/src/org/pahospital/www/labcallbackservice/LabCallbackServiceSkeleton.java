
/**
 * LabCallbackServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.pahospital.www.labcallbackservice;
/**
  *  LabCallbackServiceSkeleton java skeleton for the axisService
  */
public class LabCallbackServiceSkeleton{
	/**
      * Receive lab report from the laboratory web service 
      * 
      * @param labReport 
      * @return  
      */
	public void sendLabReport(org.pahospital.www.labcallbackservice.LabReport labReport) {
		System.out.println("\n--------- LABORATORY CALLBACK WEB SERVICE -------------");
		System.out.print("Lab report received:\n" +
				"\tLab order ID\t: "	+ labReport.getLabOrderID() +
				"\n\tPatient ID\t: "	+ labReport.getPatientID() 	+
				"\n\tSample ID\t: "		+ labReport.getSampleID() 	+
				"\n\tValues\t:\n");
		for(LabValues_type0 param : labReport.getLabValues()) {
			System.out.println("\t  -" + param.getLabParameter() + ": " + param.getLabValue());
		}
		
		System.out.println("\n-------------------------------------------------------");
	}
}
    