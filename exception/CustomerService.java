package com.m2i.poec.sept15.javse.exception;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class CustomerService {

	public static final int OPENING_HOUR = 7;
	public static final int CLOSING_HOUR = 12;
	
	/**
	 * You can call the customer service between 7am and 12am
	 * @param String customerId the customer ID
	 * @throws NullPointerException if the customerId is null
	 * @throws CustomerServiceClosedException if this method is called outside of the opening hours
	 * @throws CustomerServiceIsFullException if this method is called when the customer service is unable to answer the call
	 */
	public void call(String customerId) throws CustomerServiceClosedException, CustomerServiceIsFullException {
/*		if(customerId == null) {
			throw new NullPointerException("The customer id cannot be null");
		}*/
		Objects.requireNonNull(customerId, "The customer id cannot be null");
		
		// récupérer l'heure courante
		LocalDateTime localDateTime = LocalDateTime.now();
		// vérifier que l'on est dans bonne tranche horaire
		if((localDateTime.getHour() < OPENING_HOUR) 
		||  (localDateTime.getHour() > CLOSING_HOUR)) {
			// si non => jetter une exception
			throw new CustomerServiceClosedException("Please call us during the opening hours (7am to 12am)");
		}
		// le service client est indisponible aléatoirement...
		Random random = new Random();
		if(random.nextBoolean()) {
			throw new CustomerServiceIsFullException("We're full, please call later");
		}
		
		
		// si oui => "répondre"
		System.out.println("Hello, how can I help you ?");		
	}
	
}
