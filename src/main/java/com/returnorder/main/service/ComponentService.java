package com.returnorder.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.returnorder.main.client.ComponentClient;
import com.returnorder.main.dto.PaymentCharges;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;

@Service
public class ComponentService {
	@Autowired
	ComponentClient componentClient;

	public ProcessResponse fetchProcessResponseDetails(ProcessRequest processReqObj, String token) {
		return componentClient.processResponseDetails(processReqObj, token);
	}

	public PaymentCharges fetchStatusConfirmation(ProcessRequest processRequest, ProcessResponse processResponse,
			String token) {
		return componentClient.statusConfirmation(processResponse.getRequestId(), processRequest.getCreditCardNumber(),
				processRequest.getCardLimit(), processResponse.getProcessingCharge(), token);
	}
}
