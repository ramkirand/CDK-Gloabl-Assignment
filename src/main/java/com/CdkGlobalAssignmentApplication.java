package com;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CdkGlobalAssignmentApplication {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Hello", 1);
		map.put("Sudha", 1);
		map.forEach((k, v) -> {
			System.out.println("k:" + k + ",V:" + v);
		});
		SpringApplication.run(CdkGlobalAssignmentApplication.class, args);
	}

}
