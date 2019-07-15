package com.learncamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SimpleCamelRoute extends RouteBuilder {

	@Autowired
	Environment environment;
	
	@Override
	public void configure() throws Exception {
		
		from("{{startRoute}}")						// timer que sera executado a cada 10 seg.
			.log("Timer invoked and the body is " + environment.getProperty("message"))	// log no console
			.pollEnrich("{{fromRoute}}")	// lê arquivo da pasta data/input, deleta e não bloqueia.
			.to("{{toRoute1}}");	// envia para a pasta data/output
		
	}

}
