package com.mamdouh.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mamdouh.user.AppUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class productSerivce {
	private ProductRepo productRepo; 
	
	
	public void uploadItem(AppUser appUser,Item item) {
		
		appUser.getItems().add(item);
		productRepo.save(item);
	}
	
	public List<Item> getAllItems() {return productRepo.findAll();}
	
	public List<Item> searchByName(String item_name){
		return productRepo.findAllByName(item_name);
	}
	
	public List<Item> searchByCategory(Category c)
	{
		return productRepo.findAllByGenresContaining(c);
	}
	
	

}
