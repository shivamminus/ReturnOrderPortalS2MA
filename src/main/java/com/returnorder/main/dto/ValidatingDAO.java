package com.returnorder.main.dto;



/*
 * This DTO Class will contain object of Validating DAO
 * which will return true/false for corresponding result
*/

public class ValidatingDAO {

	private boolean validStatus;

	public ValidatingDAO() {
		super();
	}

	public ValidatingDAO(boolean validStatus) {
		super();
		this.validStatus = validStatus;
	}

	public boolean isValidStatus() {
		return validStatus;
	}

	public void setValidStatus(boolean validStatus) {
		this.validStatus = validStatus;
	}

}