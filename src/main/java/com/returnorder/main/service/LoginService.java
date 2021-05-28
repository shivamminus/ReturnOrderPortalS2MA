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
		try {
			return loginClient.loginUser(credentials);
		} catch (Exception RequestNotCompleted) {
			// TODO: handle exception
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("reached Catch of Login USER AUTH : AuthenticationResponse");
			System.out.println("RequestNotCompleted:"+ RequestNotCompleted.getMessage());
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			return null;
		}
	}
}
