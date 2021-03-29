package com.ibm.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.sevice.OrderService;

@RestController
public class UserController {
	@Autowired
	com.ibm.demo.sevice.OrderService orderservice;
	Logger logger = Logger.getLogger(UserController.class.getName());

	@GetMapping("/hello")
	String hello() {
		logger.setLevel(Level.WARNING);
		logger.log(Level.WARNING, orderservice.hashCode() + "Printed");
		return "Hello";
	}

}
