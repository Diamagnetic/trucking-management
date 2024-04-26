package com.haullog.haullog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EntityScan("com.haullog.haullog.models")
//@EnableJpaRepositories("com.haullog.haullog.repository")
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
public class HaUlLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaUlLogApplication.class, args);
	}

}
