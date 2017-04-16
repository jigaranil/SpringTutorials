package com.app1;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootnrestApplication {
	
	public static HashMap<Long,Student> hmStudent;

	public static void main(String[] args) {
		
		  hmStudent=new HashMap<Long,Student>();
	      Student one=new Student("John","math");
	      hmStudent.put(one.getId(),one);
	      SpringApplication.run(BootnrestApplication.class, args);
	      Student two=new Student("Jane","history");
	      hmStudent.put(two.getId(),two);
	}
}
