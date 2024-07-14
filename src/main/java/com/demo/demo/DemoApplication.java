package com.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.demo.demo.model.GroceryItem;
import com.demo.demo.repository.ItemRepository;

@EnableMongoRepositories
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	ItemRepository groceryItemRepo;

	void createGroceryItem(){
		System.out.println("Data creation started...");
		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "Snacks"));
		groceryItemRepo.save(new GroceryItem("Cranberry Chocolate", "Cranberry Chocolate", 3, "chocolate"));
		System.out.println("Data creation complete...");
	}

	public String getItemDetails(GroceryItem item){
		System.out.println(
			"Item Name: " + item.getName() +
			", \nQuantity: " + item.getQuantity() +
			", \nItem Category: " + item.getCategory()
		);

		return "";
	}

	public void showAllGroceryItems(){
		groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------CREATE GROCERY ITEMS-------------");
		createGroceryItem();
		System.out.println("-------------SHOW ALL GROCERY ITEMS-------------");
		showAllGroceryItems();
	}

}
