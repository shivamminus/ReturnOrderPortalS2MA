package com.returnorder.main.dto;



/*
 * This DTO Class will contain object of Process Response
*/

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProcessResponse {

	private String requestId;
	private Integer processingCharge;
	private Double packagingAndDeliveryCharge;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String dateOfDelivery;

	public ProcessResponse() {
		super();
	}

	public ProcessResponse(String requestId, Integer processingCharge, Double packagingAndDeliveryCharge,
			String dateOfDelivery) {
		super();
		this.requestId = requestId;
		this.processingCharge = processingCharge;
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
		this.dateOfDelivery = dateOfDelivery;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Integer getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(Integer processingCharge) {
		this.processingCharge = processingCharge;
	}

	public Double getPackagingAndDeliveryCharge() {
		return packagingAndDeliveryCharge;
	}

	public void setPackagingAndDeliveryCharge(Double packagingAndDeliveryCharge) {
		this.packagingAndDeliveryCharge = packagingAndDeliveryCharge;
	}

	public String getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(String dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	@Override
	public String toString() {
		return "ProcessResponse [requestId=" + requestId + ", processingCharge=" + processingCharge
				+ ", packagingAndDeliveryCharge=" + packagingAndDeliveryCharge + ", dateOfDelivery=" + dateOfDelivery
				+ "]";
	}

	
}
