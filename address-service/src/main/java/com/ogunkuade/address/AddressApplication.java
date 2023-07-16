package com.ogunkuade.address;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching      //ENABLE CACHING
public class AddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressApplication.class, args);
	}

}


