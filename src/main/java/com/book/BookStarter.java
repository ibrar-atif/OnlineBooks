package com.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Application Starter class
 * @author ibrara
 *
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class BookStarter {

	public static void main(String a[]){
		SpringApplication.run(BookStarter.class, a);
	}
}
