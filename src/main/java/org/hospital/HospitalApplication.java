package org.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(HospitalApplication.class, args);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
