package com.vr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vr.entities.inventory;
import com.vr.repository.inventoryRepository;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner{
	
	@Autowired
	private inventoryRepository invRepo;

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		invRepo.save(new inventory("sabun", 1));
		invRepo.save(new inventory("shampoo", 2));
		invRepo.save(new inventory("odol", 3));
	}

}
