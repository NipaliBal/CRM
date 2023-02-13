package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm.entities.Contacts;
import com.zohocrm.services.ContactService;

@Controller
public class ContactController {
	
	private ContactService conService;
	
	public ContactController(ContactService conService) {
		
		this.conService = conService;
	}

	@RequestMapping("/listcontact")
	public String listAllLeads(Model model) {
		List<Contacts> cons = conService.getAllContacts();
		model.addAttribute("con",cons);
		return "list_contacts";
	}
}
