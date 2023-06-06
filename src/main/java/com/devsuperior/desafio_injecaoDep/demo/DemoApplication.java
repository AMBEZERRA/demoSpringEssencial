package com.devsuperior.desafio_injecaoDep.demo;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafio_injecaoDep.demo.entities.Order;
import com.devsuperior.desafio_injecaoDep.demo.service.OrderService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;
	
		public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dados do Pedido");
		System.out.print("Código: ");
		int code = sc.nextInt();
		System.out.print("Basic: ");
		double basic = sc.nextDouble();
		System.out.println("Porcentagem de desconto: ");
		double discount  = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		System.out.println("Pedido Código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
		
		//System.out.print("Valor total: R$ ");
		//System.out.println(orderService.total(order));
	
		
		sc.close();
	}

}
