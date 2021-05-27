package com.returnorder.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.returnorder.main.dto.PaymentCharges;
import com.returnorder.main.dto.ProcessRequest;
import com.returnorder.main.dto.ProcessResponse;
import com.returnorder.main.service.ComponentService;

import feign.FeignException;

@Controller
public class ComponentController {

	@Autowired
	ComponentService componentService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView showProcessing() {
		ModelAndView mv = new ModelAndView("orderDetails");
		mv.addObject("orderModel", new ProcessRequest());
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
			System.out.println(processResponse);
			System.out.println("*******************************************************************************************");
			mv.addObject("response", processResponse);

			PaymentCharges paymentCharges = componentService.fetchStatusConfirmation(processRequest, processResponse,
					token);
			mv.addObject("payment", paymentCharges);

			mv.setViewName("cart");
			return mv;

		} catch (Exception e) {
			mv.setViewName("cart");
			return mv;

		}

	}
}
