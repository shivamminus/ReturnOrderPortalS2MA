package com.returnorder.main.dto;

/*
 * Payment Charge will return Operation Successful/ Not Successful
*/
public class PaymentChargesStatus {

	private String  status;

	public PaymentChargesStatus() {
		super();
	}

	public PaymentChargesStatus(String status) {
		this.status = status;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentChargesStatus [status=" + status + "]";
	}
	
	

}