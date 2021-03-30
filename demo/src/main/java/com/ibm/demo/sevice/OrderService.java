package com.ibm.demo.sevice;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import com.ibm.demo.entity.Order;
import com.ibm.demo.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestTemplate getTaxesTemplate;

	public String createOrder(Order order) {
		// call getTaxes
		Float tax = getTaxesTemplate.getForObject("http://localhost:8080/getTaxes?price={price}", Float.class,
				order.getPrice());
		System.out.println(tax);
		order.setTax(tax);
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

	public String getOrder() {

		return "order 1";
	}

	public void updateOrder(Order order) {

		orderRepository.save(order);
	}

	public void deleteOrder(String orderId) {

		orderRepository.deleteById(orderId);

	}

	public List<Order> getOrders() {

		return orderRepository.findAll();
	}

	public Optional<Order> getOrder(String orderID) {

		return orderRepository.findById(orderID);
	}

}