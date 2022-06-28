package com.davin111.examplenonblocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class ExampleNonblockingApplication {

	public static void main(String[] args) {
//		BlockHound.install();
		SpringApplication.run(ExampleNonblockingApplication.class, args);
	}

}
