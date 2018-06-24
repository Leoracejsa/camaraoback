package com.guaranis.camarao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guaranis.camarao.services.BackGroundService;

@SpringBootApplication	
public class GuaranisCamaraoApplication implements CommandLineRunner {
	
	@Autowired
	BackGroundService backgroundService;
	
	public static void main(String[] args) {
		SpringApplication.run(GuaranisCamaraoApplication.class, args);
	}
	 
	@Override
	public void run (String... args)throws Exception{
		backgroundService.doInBackground();
		
	}
	
	
}
	
