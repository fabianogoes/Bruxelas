package com.bruxelas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@ComponentScan({"com.bruxelas", "com.bruxelas.api", "com.bruxelas.services", "com.bruxelas.repositories"})
@SpringBootApplication
public class BruxelasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BruxelasApplication.class, args);
	}
	
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CharacterEncodingFilter characterEncodingFilter() {
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      filter.setEncoding("UTF-8");
      filter.setForceEncoding(true);
      return filter;
    }	

}
