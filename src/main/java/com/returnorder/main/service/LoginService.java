package com.returnorder.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.main.client.LoginClient;
import com.returnorder.main.dto.AuthenticationRequest;
import com.returnorder.main.dto.AuthenticationResponse;

@Service
public class LoginService {
	
	@Autowired
	LoginClient loginClient;
	
	public AuthenticationResponse getAuthToken(AuthenticationRequest credentials) {
		return loginClient.loginUser(credentials);
	}
}
