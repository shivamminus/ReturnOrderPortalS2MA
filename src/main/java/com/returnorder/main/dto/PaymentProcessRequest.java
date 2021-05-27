package com.returnorder.main.dto;

public class PaymentProcessRequest {

	private String requestId;
	private String creditCardNumber;
	private Double packagingAndDeliveryCharge;
	private Integer cardLimit;

	public PaymentProcessRequest() {
		super();
	}

	public PaymentProcessRequest(String requestId, String creditCardNumber, Double packagingAndDeliveryCharge,
			Integer cardLimit) {
		super();
		this.requestId = requestId;
		this.creditCardNumber = creditCardNumber;
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
		this.cardLimit = cardLimit;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Double getPackagingAndDeliveryCharge() {
		return packagingAndDeliveryCharge;
	}

	public void setPackagingAndDeliveryCharge(Double packagingAndDeliveryCharge) {
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
	}

	public Integer getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(Integer cardLimit) {
		this.cardLimit = cardLimit;
	}

	@Override
	public String toString() {
		return "PaymentProcessRequest [requestId=" + requestId + ", creditCardNumber=" + creditCardNumber
				+ ", packagingAndDeliveryCharge=" + packagingAndDeliveryCharge + ", cardLimit=" + cardLimit + "]";
	}

}
