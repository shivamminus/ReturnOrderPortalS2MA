package com.returnorder.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.main.client.ComponentClient;
import com.returnorder.main.dto.PaymentChargesStatus;
import com.returnorder.main.dto.PaymentProcessRequest;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * This is Service class to Component controller 
 * which will fetch data from Other microservices
*/
@Service
public class ComponentService {
	private static Logger logger = LoggerFactory.getLogger(ComponentService.class);
	
	@Autowired
	ComponentClient componentClient;

	
	/*
	 * fetchProcessResponseDetails will call  using Feign
	 *  to receive details of product
	*/
	public ProcessResponse fetchProcessResponseDetails(ProcessRequest processReqObj, String token) {
		try {
			return componentClient.processResponseDetails(processReqObj, token);
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			logger.debug("ProcessResponse : fetchProcessResponseDetails");
			logger.debug("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}

	public PaymentChargesStatus fetchStatusConfirmation(PaymentProcessRequest paymentProcessRequest, String token) {

		try {
			PaymentChargesStatus paymentStatus = componentClient.statusConfirmation(
					paymentProcessRequest.getRequestId(), paymentProcessRequest.getCreditCardNumber(),
					paymentProcessRequest.getCardLimit(),
					paymentProcessRequest.getProcessingCharge(), token);
			logger.debug("---------------------------------" + paymentStatus);
			return paymentStatus;
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			logger.debug("PaymentChargesStatus : fetchStatusConfirmation");
			logger.debug("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			logger.debug("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}
}
