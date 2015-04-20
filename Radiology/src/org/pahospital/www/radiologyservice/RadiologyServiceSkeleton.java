
/**
 * RadiologyServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package org.pahospital.www.radiologyservice;
    /**
     *  RadiologyServiceSkeleton java skeleton for the axisService
     */
public class RadiologyServiceSkeleton implements RadiologyServiceSkeletonInterface{
        
         
    	 /**
         * Auto generated method signature
         * 
         * @param appointment2 
         * @return appointment3 
         */
        
public org.pahospital.www.radiologyservice.Appointment requestAppointment(
		org.pahospital.www.radiologyservice.Appointment appointment2) {
           
                	 ServiceImpl service = ServiceImpl.getInstance();
                	 return service.RequestAppointment(appointment2);
	}
     
         
        /**
         * Auto generated method signature
         * 
         * @param radiologyOrderID4 
         * @return orderStatus5 
         */
        
	public org.pahospital.www.radiologyservice.OrderStatus getOrderStatus(
			org.pahospital.www.radiologyservice.RadiologyOrderID radiologyOrderID4) {
                	 
		ServiceImpl service = ServiceImpl.getInstance();
        return service.GetOrderStatus(radiologyOrderID4);
	
	}
     
         
        /**
         * Auto generated method signature
         * 
         * @param radiologyOrderIDForPayment6 
         * @return  
         */
        
	public void makePayment(
			org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment radiologyOrderIDForPayment6) {

		ServiceImpl service = ServiceImpl.getInstance();
        service.MakePayment(radiologyOrderIDForPayment6);
	}
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param radiologyOrder7 
             * @return radiologyOrderID8 
         */
        
	public org.pahospital.www.radiologyservice.RadiologyOrderID orderRadiologyExamination(
			org.pahospital.www.radiologyservice.RadiologyOrder radiologyOrder7) {

		ServiceImpl service = ServiceImpl.getInstance();
		return service.OrderRadiologyExamination(radiologyOrder7);
	}
     
}
    