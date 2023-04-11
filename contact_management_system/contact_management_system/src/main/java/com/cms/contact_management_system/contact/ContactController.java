package com.cms.contact_management_system.contact;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ContactController {
	
	private ContactService contactService;
	
	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
//list all contacts-->	
	@RequestMapping("contact-list")
	public String contactList(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<Contact> contacts = contactService.findByUsername(username);
	    model.addAttribute("contacts", contacts);
		return "contactlist";
	}
	
//add contact--->
//Get	
	
	@RequestMapping(value="add-contact",method = RequestMethod.GET)
	public String addContactPage(ModelMap model) {
		String username = getLoggedinUsername(model);
		Contact contact = new Contact(0,username,"","","","");
		model.put("contact", contact);
		return "addcontact";
	}
	
	@RequestMapping(value="add-contact", method = RequestMethod.POST)
	public String addNewContact(ModelMap model, @Valid Contact contact, BindingResult result) {

		if(result.hasErrors()) {
			return "addcontact";
		}

		String username = getLoggedinUsername(model);
		contactService.addContact(username,
				contact.getFname(),
				contact.getLname(),
				contact.getEmail(),
				contact.getPhone());
		
		return "redirect:contact-list";
	}
//delete contact -->
	@RequestMapping("delete-contact")
	public String deleteContact(@RequestParam int id) {
		
		contactService.deleteById(id);
		return "redirect:contact-list";
	}
	
//update contact--->
	@RequestMapping(value = "update-contact",method = RequestMethod.GET)
	public String showUpdatePage(@RequestParam int id,ModelMap model) {
		
		Contact contact = contactService.findById(id);
		model.addAttribute("contact", contact);
		return "addcontact";
	}
	@RequestMapping(value = "update-contact",method = RequestMethod.POST)
	public String updateContact(ModelMap model,@Valid Contact contact,BindingResult result) {
		if(result.hasErrors()) {
			return "addcontact";
		}
		String username = getLoggedinUsername(model);
		contact.setUsername(username);
		contactService.updataContact(contact);
		return "redirect:contact-list";
	}
	
//authentication --->	
	private String getLoggedinUsername(ModelMap model) {
		 Authentication authentication =
				 SecurityContextHolder.getContext().getAuthentication();
		 return authentication.getName();
	}

}
