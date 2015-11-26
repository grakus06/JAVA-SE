package com.m2i.poec.sept15.javse.exception;

public class MainCustomerService {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();

			try {
				customerService.call("12345");
/*			} catch (CustomerServiceClosedException | CustomerServiceIsFullException e) {
				e.printStackTrace();
			}*/
			} catch (CustomerServiceClosedException e) {
				System.out.println("L'appel a échoué car le service client est fermé");
				e.printStackTrace();
			} catch (CustomerServiceIsFullException e) {
				System.out.println("L'appel a échoué car le service client est plein");
				e.printStackTrace();
			} finally {
				System.out.println("Ce code s'exécute toujours, exception ou pas");
			}

	}
}
