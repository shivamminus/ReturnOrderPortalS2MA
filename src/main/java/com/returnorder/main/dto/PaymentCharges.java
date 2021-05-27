package com.returnorder.main.dto;
public class PaymentCharges {

	private Double charge;

	public PaymentCharges(Double charge) {
		this.charge = charge;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

}