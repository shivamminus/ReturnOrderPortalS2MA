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
			ProcessResponse processResponse = componentClient.processResponseDetails(processReqObj, token);
			logger.info("here it is "+processResponse);
			return processResponse;
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			logger.error("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			logger.error("ProcessResponse : fetchProcessResponseDetails");
			logger.error("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			logger.error("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}

	public PaymentChargesStatus fetchStatusConfirmation(PaymentProcessRequest paymentProcessRequest, String token) {

		try {
			PaymentChargesStatus paymentStatus = componentClient.statusConfirmation(
					paymentProcessRequest.getRequestId(), paymentProcessRequest.getCreditCardNumber(),
					paymentProcessRequest.getCardLimit(),
					paymentProcessRequest.getProcessingCharge(), token);
			logger.info("---------------------------------" + paymentStatus);
			return paymentStatus;
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			logger.info("PaymentChargesStatus : fetchStatusConfirmation");
			logger.info("RequestNotCompleted:" + RequestNotCompleted.getMessage());
			logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return null;
		}
	}
}
