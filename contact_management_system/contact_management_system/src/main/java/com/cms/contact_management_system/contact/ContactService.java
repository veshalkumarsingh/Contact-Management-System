package com.cms.contact_management_system.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ContactService {
	
	private static List<Contact> contacts = new ArrayList<>();
	
	private static int cCount = 0;
	
	public List<Contact> findByUsername(String username) {
		
		Predicate<? super Contact> predicate = 
				contact -> contact.getUsername().equalsIgnoreCase(username);
		
				return contacts.stream().filter(predicate ).toList();
		
	}

	public void addContact(String username, String fname, String lname, String email, String phone) {
		Contact contact = new Contact(++cCount,username,fname,lname,email,phone);
		contacts.add(contact);
		
	}

	public void deleteById(int id) {
		
		Predicate<? super Contact> predicate = c -> c.getId() == id;
		contacts.removeIf(predicate );
	}

	public Contact findById(int id) {
		
		Predicate<? super Contact> predicate = c -> c.getId() == id;
		Contact contact = contacts.stream().filter(predicate).findFirst().get();
	    return contact;
	}

	public void updataContact(@Valid Contact contact) {
		deleteById(contact.getId());
		contacts.add(contact);
		
	}

	

}
