package org.pahospital.www.radiologyservice;

import java.util.HashMap;
import java.util.Map;

import org.pahospital.www.radiologycallbackservice.RadiologyCallbackServiceStub;

class ServiceImpl {
	// Singleton pattern, because the ServiceSkeleton is reconstructed
	// for every request
	private static ServiceImpl instance = null;
	public static ServiceImpl getInstance() {
		if(instance == null) {
			instance = new ServiceImpl();
		}
		return instance;
	}
	
	private static final String CALLBACK_URL = "http://192.168.216.1:8080/ode/processes/RadiologyCallbackService";
	
	private int orderCounter = 1000;	
	private Map<String, RadiologyOrder> ordersByOrderId = new HashMap<String, RadiologyOrder>();
	private Map<String, OrderStatus> statusByOrderId = new HashMap<String, OrderStatus>();
	private Map<String, Appointment> appointmentsByOrderId = new HashMap<String, Appointment>();

	//request a certain examination from the radiology department;
	public RadiologyOrderID OrderRadiologyExamination(RadiologyOrder order){
		System.out.println("----------------------------------------");
		System.out.println(" OrderRadiologyExamination() is called");
		System.out.println("----------------------------------------");

		orderCounter++;
		RadiologyOrderID radiologyId = new RadiologyOrderID();
		radiologyId.setRadiologyOrderID(String.valueOf(orderCounter)+"_"+order.getExaminationType());
		ordersByOrderId.put(radiologyId.getRadiologyOrderID(), order);
		
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setOrderStatus("ordered");
		orderStatus.setOrderID(radiologyId.getRadiologyOrderID());
		statusByOrderId.put(orderStatus.getOrderID(), orderStatus);
		
		return radiologyId;
	}
	
	//request an appointment for a previously ordered radiology examination;
	public Appointment RequestAppointment(Appointment requestAppointment){
		
		System.out.println("---------------------------");
		System.out.println(" RequestAppointment() is called");
		System.out.println("---------------------------");

		if(!ordersByOrderId.containsKey(requestAppointment.getOrderID())){
			return null;
		}
		if(appointmentsByOrderId.containsKey(requestAppointment.getOrderID())){
			return null;
		}
		
		appointmentsByOrderId.put(requestAppointment.getOrderID(), requestAppointment);			
		statusByOrderId.get(requestAppointment.getOrderID())
			.setOrderStatus("appointment_made");

		return requestAppointment;
	}
	
	//retrieve the current status of a radiology order (e.g., ordered, appointment made, report sent);
	public OrderStatus GetOrderStatus(RadiologyOrderID orderId){
		System.out.println("---------------------------");
		System.out.println(" GetOrderStatus() is called");
		System.out.println("---------------------------");

		return statusByOrderId.get(orderId.getRadiologyOrderID());
	}
	
	//pay for a performed radiology examination
	public void MakePayment(RadiologyOrderIDForPayment orderIdForPayment){
		
		System.out.println("---------------------------");
		System.out.println(" MakePayment() is called");
		System.out.println("---------------------------");
		String orderId = orderIdForPayment.getRadiologyOrderIDForPayment();
		RadiologyOrder order = ordersByOrderId.get(orderId);
		Appointment appointment = appointmentsByOrderId.get(orderId);
		
		RadiologyCallbackServiceStub.RadiologyReport report = new RadiologyCallbackServiceStub.RadiologyReport();
		report.setPatientID(order.getPatientID());
		report.setRadiologyOrderID(orderId);
		report.setDateOfExamination(appointment.getDate());
		report.setReportText("Still very sick"); 
		
		try {
			System.out.println(" calling radiologycallback()..");
			RadiologyCallbackServiceStub callback = new RadiologyCallbackServiceStub(CALLBACK_URL);
			callback.sendRadiologyReport(report);
			statusByOrderId.get(orderId).setOrderStatus("report_sent");
		} catch(Exception e) {
			throw new Error(e);
		}
	}
}
