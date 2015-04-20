
/**
 * Wardv2CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package org.pahospital.www.ward;

    /**
     *  Wardv2CallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class Wardv2CallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public Wardv2CallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public Wardv2CallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for order method
            * override this method for handling normal response from order operation
            */
           public void receiveResultorder(
                    org.pahospital.www.ward.Wardv2Stub.Wardv2Response result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from order operation
           */
            public void receiveErrororder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateReport method
            * override this method for handling normal response from validateReport operation
            */
           public void receiveResultvalidateReport(
                    org.pahospital.www.ward.Wardv2Stub.ValidateReportResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateReport operation
           */
            public void receiveErrorvalidateReport(java.lang.Exception e) {
            }
                


    }
    