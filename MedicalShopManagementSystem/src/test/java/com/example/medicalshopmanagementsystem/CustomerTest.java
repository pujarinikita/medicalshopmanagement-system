package com.example.medicalshopmanagementsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.medicalshopmanagementsystem.entity.Customer;
import com.example.medicalshopmanagementsystem.repository.CustomerRepository;




@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CustomerTest {

	
	@Autowired
	CustomerRepository cRepo;
	
	@Test
	   @Order(1)
		public void testCreateCustomer() {
		   
		  Customer cust=new Customer();
		 
		  cust.setCustomerId((long) 1101);
		  cust.setCustomerName("Shashikala");
		  cust.setCustomerPhoneNo("7909678954");
		  cust.setCustomerAddress("Karminagar");
		  
		  cRepo.save(cust);
		  
		  assertNotNull(cRepo.findById((long) 1101).get()); 
			
		}
	   
	   @Test
	   @Order(2)
	   public void testReadAllCustomer() {
		   List<Customer> list=cRepo.findAll();
		   assertThat(list).size().isGreaterThan(0);
		   
		   
	   }
	   @Test
	   @Order(3)
	   public void testSingleCustomer() {
		   Customer customer=cRepo.findById((long) 1002).get();
		   assertEquals("Advik",customer.getCustomerName());
		   
	   }
	   @Test
	   @Order(4)
	   public void testUpdateCustomer() {
		 Customer c=cRepo.findById((long) 1001).get();
		 c.setCustomerName("vinay");
		 cRepo.save(c);
		 assertNotEquals("Amit",cRepo.findById((long) 1001).get().getCustomerName());
		   
	   }
	   @Test
	   @Order(5)
	   public void testDeleteCustomer() {
		   cRepo.deleteById((long) 1201);
		   assertThat(cRepo.existsById((long) 1201)).isFalse();
	   }
	   

	}


