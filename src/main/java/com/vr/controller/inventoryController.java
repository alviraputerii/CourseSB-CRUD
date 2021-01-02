package com.vr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vr.entities.inventory;
import com.vr.repository.inventoryRepository;

@Controller
public class inventoryController {

	@Autowired
	private inventoryRepository invRepo;
	
	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("data", invRepo.findAll());
		return "index";
	}
	
	@GetMapping("/tambah")
	public String tambah() {
		return "add";
	}
	
	@PostMapping("/save")
	public String simpan(inventory i) {
		invRepo.save(i);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String hapus(Integer id) {
		invRepo.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/findInventory")
	public String findInventory(Integer id, Model model) {
		model.addAttribute("data", invRepo.findById(id).orElse(null));
		return "edit";
	}
	
		
}
