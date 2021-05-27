package com.returnorder.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.main.client.ComponentClient;
import com.returnorder.main.dto.PaymentChargesStatus;
import com.returnorder.main.dto.PaymentProcessRequest;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;

@Service
public class ComponentService {
	@Autowired
	ComponentClient componentClient;

	public ProcessResponse fetchProcessResponseDetails(ProcessRequest processReqObj, String token) {
		return componentClient.processResponseDetails(processReqObj, token);
	}

	public PaymentChargesStatus fetchStatusConfirmation(PaymentProcessRequest paymentProcessRequest,
			String token) {
		PaymentChargesStatus paymentStatus =  componentClient.statusConfirmation(paymentProcessRequest.getRequestId(), paymentProcessRequest.getCreditCardNumber(),
				paymentProcessRequest.getCardLimit(), paymentProcessRequest.getPackagingAndDeliveryCharge(), token);
		System.out.println("---------------------------------"+paymentStatus);
		return paymentStatus;
	}
}
