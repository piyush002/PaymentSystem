package com.piyush.banking.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class PaymentController {

	@RequestMapping("/Sample")
	public String test(){
		return "Hello Piyush";
	}
}
