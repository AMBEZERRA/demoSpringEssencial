package com.devsuperior.desafio_injecaoDep.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.desafio_injecaoDep.demo.entities.Order;
@Service
public class OrderService {
	@Autowired
	private ShippingService shippingService;
		
	public double total(Order order) {
		return order.getBasic() - (order.getBasic() * (order.getDiscount() / 100))
				+ shippingService.shipment(order);
	}

}
