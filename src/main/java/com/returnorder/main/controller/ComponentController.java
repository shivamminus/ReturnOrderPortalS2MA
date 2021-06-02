package com.returnorder.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	private static Logger logger = LoggerFactory.getLogger(ComponentController.class);

	@Autowired
	ComponentService componentService;
	
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	/*
	 * This Method will render order.jsp based on authenticated token
	*/
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView showProcessing(HttpSession request) {
		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("redirect:/login");
			return mv;
		}
		mv = new ModelAndView("order-details");
		mv.addObject("orderModel", new ProcessRequest());
		return mv;
	}

//	@RequestMapping(value = "/payment-status", method = RequestMethod.GET)
//	public ModelAndView showProcessedPayment() {
//		ModelAndView mv = new ModelAndView("paymentStatus");
//		mv.addObject("paymentModel", new ProcessRequest());
//		return mv;
//	}

	
	/*
	 * This Method will render payment.jsp based on inputs from order.jsp
	*/
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ModelAndView paymentDetails(@ModelAttribute("paymentModel") PaymentProcessRequest paymentProcessRequest,
			HttpSession request) {
		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("redirect:/login");
			return mv;
		}

		PaymentChargesStatus paymentChargesStatus = componentService.fetchStatusConfirmation(paymentProcessRequest,
				token);
		if (paymentChargesStatus == null) {
			mv = new ModelAndView("cart");
			logger.error("Error in Transaction");
			mv.addObject("error", "Error in Transaction");
			return mv;
		}
		System.out
				.println("*******************************************************************************************");
		logger.debug(paymentChargesStatus.toString());
		mv = new ModelAndView("paymentStatus");
		mv.addObject("payment", paymentChargesStatus);
		mv.addObject("paymentModel", paymentProcessRequest);
		return mv;
	}
	
	
	/*
	 * This Method will post data to cart.jsp along with calls to Process the order
	*/
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView displayOrderPage(@ModelAttribute("orderModel") ProcessRequest processRequest,
			BindingResult result, HttpSession request) throws FeignException {

		String token = (String) request.getAttribute("token");
		ModelAndView mv;
		if (token == null) {
			mv = new ModelAndView("redirect:/login");
			return mv;
		}

		mv = new ModelAndView("order-details");
		if (result.hasErrors()) {
			return mv;
		}

		try {
			ProcessResponse processResponse = componentService.fetchProcessResponseDetails(processRequest, token);
			if (processResponse == null) {
				mv = new ModelAndView("order-details");
				mv.addObject("error", "Error in Getting Details...");
				return mv;
			}

			logger.info(
					"*******************************************************************************************");
			logger.info(processRequest.toString());
			logger.info(processResponse.toString());
			logger.info(
					"*******************************************************************************************");
			mv.addObject("request", processRequest);
			mv.addObject("response", processResponse);
			

			mv.setViewName("cart");
			return mv;

		} catch (Exception e) {
			logger.error("======================================================>" + e.getMessage());
			mv.addObject("error", e.getMessage());
			mv.setViewName("cart");
			return mv;

		}

	}
}
