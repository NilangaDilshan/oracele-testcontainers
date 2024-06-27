package com.testcontainers.oracletestcontainers.defaultgeneratedcode;

import com.testcontainers.oracletestcontainers.OracleTestcontainersTestApplication;
import org.springframework.boot.SpringApplication;

public class TestOracleTestcontainersTestApplication {

	public static void main(String[] args) {
		SpringApplication.from(OracleTestcontainersTestApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
