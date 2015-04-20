
/**
 * RadiologyServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package org.pahospital.www.radiologyservice;
    /**
     *  RadiologyServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface RadiologyServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                    * @param appointment
         */

        
                public org.pahospital.www.radiologyservice.Appointment requestAppointment
                (
                  org.pahospital.www.radiologyservice.Appointment appointment
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param radiologyOrderID
         */

        
                public org.pahospital.www.radiologyservice.OrderStatus getOrderStatus
                (
                  org.pahospital.www.radiologyservice.RadiologyOrderID radiologyOrderID
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param radiologyOrderIDForPayment
         */

        
                public void makePayment
                (
                  org.pahospital.www.radiologyservice.RadiologyOrderIDForPayment radiologyOrderIDForPayment
                 )
            ;
        
         
        /**
         * Auto generated method signature
         * 
                                    * @param radiologyOrder
         */

        
                public org.pahospital.www.radiologyservice.RadiologyOrderID orderRadiologyExamination
                (
                  org.pahospital.www.radiologyservice.RadiologyOrder radiologyOrder
                 )
            ;
        
         }
    