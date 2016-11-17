package com.parking.stability;

/**
 * @author paridhika
 *
 */
public class Stability_condition {

	/**
	 * @param args
	 */
	private double lambda1;
	private double lambda2;
	private double beta;
	private static double nu;   //Avg wait time in parking
	private static double mu1;	//Get service time in second
	private static double mu2;  //Put service time in second
	private static double mu3;  //Delete service time in second
	private static void initialize_coap(){
		mu1 = 0.00225; //get 
		mu2 = 0.058;   //put
		mu3 = 0.058; //delete
		nu = 1;
	}
	private static void initialize_mqtt(){
		mu1 = 0.0035; //get 
		mu2 = 0.0015; //put
		mu3 = 0.0015; //delete
		nu = 0.3;
	}
	
	private static void initialize_xmpp(){
		mu1 = 0.015; //get
		mu2 = 0.015; //put
		mu3 = 0.015; //delete
		nu = 0.3;
	}
	
	private static void initialize_mqttws(){
		mu1 = 0.05;  //get
		mu2 = 0.0025; //put
		mu3 = 0.0025; //delete
		nu = 1;
	}
	private static void server_utilization(double utilization){
		for (double i = 0.1; i<(67/nu);i+=0.01){
			for( double j=0.1;(i+j) < (67/nu); j+=0.05){
				double a = i*(mu1+mu3*nu);
				double b = j*(mu2+mu3*nu);
				if(a+b >= (utilization-0.0001) && a+b <= (utilization+0.0001)){
					System.out.println("i = " + i + " j = " + j);
					System.out.println("a+b = " + (a+b));
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize_coap();
		//initialize_mqtt();
		//initialize_xmpp();
		initialize_mqttws();
		server_utilization(0.2);
	//	server_utilization(0.6);
	//	server_utilization(0.8);
	}
	
	 /* CoAP Utilization rates
	  * 20% - get = 1.2 put = 1.1
	  * 60% - get = 5.05 put = 2.55
	  * 80% - get = 7.56 put = 2.95
	 */
	
	 /* MQTT Utilization rates
	  * 20% - get = 1.0 put = 97.5 
	  * 60% - get = 98.5 put = 102.0
	  * 80% - get = 189.0 put = 21
	 */
	
	 /* XMPP Utilization rates
	  * 20% - get = 3.2 put = 7.05 
	  * 60% - get = 13.27 put = 17.5
	  * 80% - get = 19.98 put = 20.05
	 */
	
	 /* MQTTWS Utilization rates
	  * 20% - get = 3.5 put = 3.15
	  * 60% - get = 10.48 put = 9.95
	  * 80% - get = 14.37 put = 9.0
	 */

}
