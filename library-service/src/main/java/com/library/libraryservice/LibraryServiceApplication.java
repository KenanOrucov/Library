package com.library.libraryservice;

import com.library.libraryservice.client.RetrieveErrorMessageDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	//reseliense gore commente alinib bunlar. o olmasa bunlari ac

/*
	// Feign Client Error Handling

	//bu olmasa ErrorDecoder islemecek
	@Bean
	public ErrorDecoder errorDecoder(){
		return new RetrieveErrorMessageDecoder();
	}

	//Loglamaq ucun
	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}

*/
}
