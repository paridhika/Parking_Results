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
		nu = 0.1;
	}
	
	private static void initialize_xmpp(){
		mu1 = 0.025; //get
		mu2 = 0.025; //put
		mu3 = 0.025; //delete
		nu = 1;
	}
	
	private static void initialize_mqttws(){
		mu1 = 0.05;  //get
		mu2 = 0.0025; //put
		mu3 = 0.0025; //delete
		nu = 1;
	}
	private static void server_utilization(double utilization){
		for (double i = 0.1; i<(67/nu);i+=0.01){
			for( double j=0.1;(i+j) < (67/nu); j+=0.01){
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
	//	initialize_coap();
	//	initialize_mqtt();
	//	initialize_xmpp();
		initialize_mqttws();
		server_utilization(0.2);
	//	server_utilization(0.4);
	//	server_utilization(0.6);
	//	server_utilization(0.8);
	}
	
	 /* CoAP Utilization rates
	  * 20% - get = 1.2 put = 1.1
	  * 40% - get = 1.2 put = 1.1
	  * 60% - get = 5.05 put = 2.55	//i = 3.38499999999995 j = 3.4149999
	  * 80% - get = 7.56 put = 2.95  //i = 4.99999999999999 j = 4.299999999999993
	 */
	
	 /* MQTT Utilization rates
	  * 20% - get = 1.0 put = 97.5 	// i = 37.7 j = 37.8
	  * 40% - get = 75.49999 put = 75.39999
	  * 60% - get = 98.5 put = 102.0  // i = 113.199 j = 113.199 
	  * 80% - get = 189.0 put = 21   // i = 150.899999 j = 150.999999
	 */
	
	 /* XMPP Utilization rates
	  * 20% - get = 2.15 put = 1.85 //
	  * 40% - get = 4 put = 4
	  * 60% - get = 8.04 put = 3.95 //  5.9999
	  * 80% - get = 8.3 put = 7.7  //7.9999
	 */
	
	 /* MQTTWS Utilization rates
	  * 20% - get = 3.479999 put = 3.479999
	  * 40% - get = 6.95999 put = 6.9399 
	  * 60% - get = 10.44 put = 10.4
	  * 80% - get = 13.91 put = 13.95
	 */

}
