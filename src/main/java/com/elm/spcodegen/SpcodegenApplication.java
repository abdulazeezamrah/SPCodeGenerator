package com.elm.spcodegen;

import com.elm.spcodegen.main.SpDaoCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpcodegenApplication implements CommandLineRunner {
	@Autowired
	private SpDaoCodeGenerator codeGenerator;

	public static void main(String[] args) {
		SpringApplication.run(SpcodegenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			for(String message : codeGenerator.generateCode()){
				System.out.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

