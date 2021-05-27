package com.returnorder.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginModel", new AuthenticationRequest());
		return mv;
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