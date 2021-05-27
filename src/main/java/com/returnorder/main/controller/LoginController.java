package com.returnorder.main.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.returnorder.main.dto.AuthenticationRequest;
import com.returnorder.main.dto.AuthenticationResponse;
import com.returnorder.main.service.LoginService;

import feign.FeignException;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;


	 
	@GetMapping("/hello")
	public String helloProcessing() {
		return "ok";
	}

//	@GetMapping("/login")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpSession request) {
		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token != null) {
			mv = new ModelAndView("login");
			return mv;
		}
		mv = new ModelAndView("order");
		mv.addObject("loginModel", new AuthenticationRequest());
		return mv;
	}
	
	@GetMapping(value = "/image")
	public @ResponseBody byte[] getImage() throws IOException {
	    InputStream in = getClass()
	      .getResourceAsStream("/com/returnorder/main/webapp/WEB-INF/jsp/css/ROM.png");
	    return IOUtils.toByteArray(in);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView performLogin(@ModelAttribute("loginModel") AuthenticationRequest credentials, BindingResult result,
			HttpSession request) throws FeignException {
		ModelAndView mv = new ModelAndView("login");

		AuthenticationResponse token = null;

		try {
			token = loginService.getAuthToken(credentials);
		} catch (Exception e) {
			mv.addObject("error", "Invalid Credentials");
			return mv;
		}

		request.setAttribute("token", "Bearer " + token.getJwtAuthToken());
		request.setAttribute("user", token.getUserName());

		return new ModelAndView(new RedirectView("order"));

	}

	
}