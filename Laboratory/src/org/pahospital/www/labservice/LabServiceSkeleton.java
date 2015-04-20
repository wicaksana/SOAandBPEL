
/**
 * LabServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.pahospital.www.labservice;

import java.math.BigDecimal;
import java.rmi.RemoteException;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.axis2.AxisFault;
import org.pahospital.www.labcallbackservice.LabCallbackServiceStub;
import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabReport;
import org.pahospital.www.labcallbackservice.LabCallbackServiceStub.LabValues_type0;

/**
     *  LabServiceSkeleton java skeleton for the axisService
     */
public class LabServiceSkeleton{
	static Integer labOrderCounter = 0;
	//private static final String defaultUrl = "http://192.168.216.1:8080/axis2/services/LabCallbackService";
	private static final String defaultUrl = "http://192.168.216.1:8080/ode/processes/LabCallbackService";
	public static LabCallbackServiceStub stub;
	List<LabReport> labReports; //the 'database'
	
	public LabServiceSkeleton() {
		labReports = new ArrayList<LabReport>();
	}
        /**
         * Auto generated method signature
         * 
         * @param labOrder 
         * @return labOrderId 
         * @throws InterruptedException 
         * @throws RemoteException 
         */
        
	public org.pahospital.www.labservice.LabOrderId orderLabTest(org.pahospital.www.labservice.LabOrder labOrder) 
			throws InterruptedException, RemoteException {
		//create new instance of LabOrderId as response
		LabOrderId response = new LabOrderId();
		stub = 	new LabCallbackServiceStub(defaultUrl);
		LabReport labReport = new LabCallbackServiceStub.LabReport();
		LabValues_type0[] labValues = new LabValues_type0[labOrder.getLabParameter().length];
		
		//logging purposes
		System.out.println("--------- LABORATORY WEB SERVICE -------------");
		System.out.println("- There is a lab request..");
		System.out.println("----------------------------------------------");
		
		//1. assign labOrderId, construct labReport to be sent using callback method, and 
		//   save the lab report to the 'database'
		labOrderCounter++;
		System.out.println("labOrderCounter: " + labOrderCounter);
		response.setLabOrderId("LAB_" + labOrderCounter.toString());
		
		//random number for test result
		Random generator = new Random();
		
		//Simulate the lab:
		//- assign all lab parameters requested by client with some random number
		
		for(int i = 0; i < labOrder.getLabParameter().length; i++) {
			labValues[i] = new LabCallbackServiceStub.LabValues_type0(); 
			labValues[i].setLabParameter(labOrder.getLabParameter()[i]);
			labValues[i].setLabValue(new BigDecimal(generator.nextInt(1000) + 93));
		}

		//logging purpose
		
		//arrange labReport to be sent back to the client
		labReport.setLabOrderID(response.getLabOrderId());
		labReport.setLabValues(labValues);
		labReport.setPatientID(labOrder.getPatientID());
		labReport.setSampleID(labOrder.getSampleID());
		
		//add lab report to the 'database'
		labReports.add(labReport);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//send lab report to LabCallbackService
		try {
			System.out.println("send lab report to callback..");
			stub.sendLabReport(labReport);
		} 
		catch(AxisFault e) {
			e.printStackTrace();
		}
				
		//4. return the labId
		return response;
	}
}
    