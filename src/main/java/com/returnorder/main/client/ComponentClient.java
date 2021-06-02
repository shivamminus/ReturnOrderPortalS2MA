package com.returnorder.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnorder.main.dto.PaymentChargesStatus;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;


@FeignClient(name = "COMPONENT-SERVICE", url = "http://component.us-east-2.elasticbeanstalk.com/componentservice")
public interface ComponentClient {
    @PostMapping("/ProcessDetail")
    ProcessResponse processResponseDetails(@RequestBody ProcessRequest processRequestObj ,@RequestHeader(name = "Authorization", required = true) String token);

    @PostMapping("/completeProcessing/{requestId}/{cardNumber}/{creditLimit}/{processingCharge}")
    PaymentChargesStatus statusConfirmation(@PathVariable String requestId, @PathVariable String cardNumber,
			@PathVariable Integer creditLimit, @PathVariable Integer processingCharge ,@RequestHeader(name = "Authorization", required = true) String token);

    
}
    