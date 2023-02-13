package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.services.ContactService;

@Controller
public class BillingController {
	 
	@Autowired
	private ContactService conService;
	
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id, Model model) {
		Contacts contact=conService.getContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
}
