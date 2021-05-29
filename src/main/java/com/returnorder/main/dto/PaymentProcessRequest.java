package com.returnorder.main.dto;


/*
 * This DTO Class will contain object of Payment Process Request
*/
public class PaymentProcessRequest {

	private String requestId;
	private String creditCardNumber;
	private Integer processingCharge;
	private Integer cardLimit;

	public PaymentProcessRequest() {
		super();
	}

	public PaymentProcessRequest(String requestId, String creditCardNumber, Integer processingCharge,
			Integer cardLimit) {
		super();
		this.requestId = requestId;
		this.creditCardNumber = creditCardNumber;
		this.processingCharge = processingCharge;
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

	public Integer getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(Integer processingCharge) {
		this.processingCharge = processingCharge;
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
				+ ", processingCharge=" + processingCharge + ", cardLimit=" + cardLimit + "]";
	}

}
