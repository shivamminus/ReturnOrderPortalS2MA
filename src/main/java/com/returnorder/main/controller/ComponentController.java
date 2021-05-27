package com.returnorder.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.returnorder.main.dto.PaymentChargesStatus;
import com.returnorder.main.dto.PaymentProcessRequest;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;
import com.returnorder.main.service.ComponentService;

import feign.FeignException;

@Controller
public class ComponentController {

	@Autowired
	ComponentService componentService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView showProcessing(HttpSession request) {
		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("login");
			return mv;
		}
		mv = new ModelAndView("orderDetails");
		mv.addObject("orderModel", new ProcessRequest());
		return mv;
	}
	
//	@RequestMapping(value = "/payment-status", method = RequestMethod.GET)
//	public ModelAndView showProcessedPayment() {
//		ModelAndView mv = new ModelAndView("paymentStatus");
//		mv.addObject("paymentModel", new ProcessRequest());
//		return mv;
//	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView paymentDetails(@ModelAttribute("paymentModel") PaymentProcessRequest paymentProcessRequest, HttpSession request) {
		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("login");
			return mv;
		}
		PaymentChargesStatus paymentChargesStatus = componentService.fetchStatusConfirmation(paymentProcessRequest,token);
		System.out.println("*******************************************************************************************");
		System.out.println(paymentChargesStatus);
		mv = new ModelAndView("paymentStatus");
		mv.addObject("payment", paymentChargesStatus);
		mv.addObject("paymentModel", paymentProcessRequest);
		return mv;
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView displayOrderPage(@ModelAttribute("orderModel") ProcessRequest processRequest,
			BindingResult result, HttpSession request) throws FeignException {

		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("login");
			return mv;
		}

		mv = new ModelAndView("orderDetails");
		if (result.hasErrors()) {
			return mv;
		}

		try {
			ProcessResponse processResponse = componentService.fetchProcessResponseDetails(processRequest, token);
			
			System.out.println("*******************************************************************************************");
			System.out.println(processRequest);
			System.out.println(processResponse);
			System.out.println("*******************************************************************************************");
			mv.addObject("response", processResponse);
			mv.addObject("request", processRequest);


			mv.setViewName("cart");
			return mv;

		} catch (Exception e) {
			System.out.println("======================================================>"+e.getMessage());
			mv.addObject("error",e.getMessage());
			mv.setViewName("cart");
			return mv;

		}

	}
}
