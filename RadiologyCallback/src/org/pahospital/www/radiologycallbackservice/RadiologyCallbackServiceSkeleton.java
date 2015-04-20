
/**
 * RadiologyCallbackServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package org.pahospital.www.radiologycallbackservice;
    /**
     *  RadiologyCallbackServiceSkeleton java skeleton for the axisService
     */
public class RadiologyCallbackServiceSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
         * @param radiologyReport 
         * @return  
         */
        
	public void sendRadiologyReport(org.pahospital.www.radiologycallbackservice.RadiologyReport radiologyReport) {
			
		System.out.println("****************************************************************");
		System.out.println("                    RADIOLOGY REPORT                            ");
		System.out.println("patient ID: " + radiologyReport.getPatientID());
		System.out.println("order ID: " + radiologyReport.getRadiologyOrderID());
		System.out.println("report: " + radiologyReport.getReportText());
		System.out.println("date: " + radiologyReport.getDateOfExamination().toString());
		System.out.println("****************************************************************");
	}     
}
    