package ru.telda.teldatesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.telda.teldatesttask.*"})
@EnableCaching
public class TeldaTestTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeldaTestTaskApplication.class, args);
	}

}
