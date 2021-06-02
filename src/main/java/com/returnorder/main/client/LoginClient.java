package com.returnorder.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.returnorder.main.dto.AuthenticationRequest;
import com.returnorder.main.dto.AuthenticationResponse;



@FeignClient(name = "AUTH-SERVICE", url = "http://s2ma-pod3.us-east-2.elasticbeanstalk.com/auth")
public interface LoginClient {

	@PostMapping(value = "/login")
	public AuthenticationResponse loginUser(@RequestBody AuthenticationRequest credentials);

}