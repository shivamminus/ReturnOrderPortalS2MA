package com.returnorder.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnorder.main.dto.PaymentCharges;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;


@FeignClient(name = "COMPONENT-SERVICE", url = "http://localhost:9090/componentservice")
public interface ComponentClient {
    @PostMapping("/ProcessDetail")
    ProcessResponse processResponseDetails(@RequestBody ProcessRequest processRequestObj ,@RequestHeader(name = "Authorization", required = true) String token);

    @PostMapping("/completeProcessing/{requestId}/{cardNumber}/{creditLimit}/{processingCharge}")
	PaymentCharges statusConfirmation(@PathVariable String requestId, @PathVariable String cardNumber,
			@PathVariable Integer creditLimit, @PathVariable Integer processingCharge ,@RequestHeader(name = "Authorization", required = true) String token);

    
}
    