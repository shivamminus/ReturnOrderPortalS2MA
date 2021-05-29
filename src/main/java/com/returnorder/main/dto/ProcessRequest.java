package com.returnorder.main.dto;




/*
 * This DTO Class will contain object of Process Request
*/
public class ProcessRequest {

	private String userName;

	private Long contactNumber;

	private String creditCardNumber;

	private Integer cardLimit;

	private Boolean isPriorityRequest;

	private String componentType;

	private String componentName;

	private Integer quantity;

	public ProcessRequest() {
		super();
	}

	public ProcessRequest(String userName, Long contactNumber, String creditCardNumber, Integer cardLimit,
			Boolean isPriorityRequest, String componentType, String componentName, Integer quantity) {
		super();
		this.userName = userName;
		this.contactNumber = contactNumber;
		this.creditCardNumber = creditCardNumber;
		this.cardLimit = cardLimit;
		this.isPriorityRequest = isPriorityRequest;
		this.componentType = componentType;
		this.componentName = componentName;
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Integer getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(Integer cardLimit) {
		this.cardLimit = cardLimit;
	}

	public Boolean getIsPriorityRequest() {
		return isPriorityRequest;
	}

	public void setIsPriorityRequest(Boolean isPriorityRequest) {
		this.isPriorityRequest = isPriorityRequest;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProcessRequest [userName=" + userName + ", contactNumber=" + contactNumber + ", creditCardNumber="
				+ creditCardNumber + ", cardLimit=" + cardLimit + ", isPriorityRequest=" + isPriorityRequest
				+ ", componentType=" + componentType + ", componentName=" + componentName + ", quantity=" + quantity
				+ "]";
	}

}
