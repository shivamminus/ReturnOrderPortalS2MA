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
		try {
			return componentClient.processResponseDetails(processReqObj, token);
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("ProcessResponse : fetchProcessResponseDetails");
			System.out.println("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}

	public PaymentChargesStatus fetchStatusConfirmation(PaymentProcessRequest paymentProcessRequest, String token) {

		try {
			PaymentChargesStatus paymentStatus = componentClient.statusConfirmation(
					paymentProcessRequest.getRequestId(), paymentProcessRequest.getCreditCardNumber(),
					paymentProcessRequest.getCardLimit(),
					paymentProcessRequest.getProcessingCharge(), token);
			System.out.println("---------------------------------" + paymentStatus);
			return paymentStatus;
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("PaymentChargesStatus : fetchStatusConfirmation");
			System.out.println("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}
}
