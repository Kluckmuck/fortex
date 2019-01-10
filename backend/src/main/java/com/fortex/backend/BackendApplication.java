package com.fortex.backend;

import com.fortex.backend.waybillinstance.elements.ElementStringValue;
import com.fortex.backend.waybillinstance.elmentfactory.AbstractFactory;
import com.fortex.backend.waybillinstance.elmentfactory.ElementFactory;
import com.fortex.backend.waybillinstance.elmentfactory.ElementValue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		// SpringApplication.run(BackendApplication.class, args);

		AbstractFactory elementFactory = new ElementFactory();
		ElementValue elementStringValue = elementFactory.getElementType("String");
		elementStringValue.addValue(1L);
		System.out.println(elementStringValue.toString());
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
