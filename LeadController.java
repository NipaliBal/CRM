package com.zohocrm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.entities.Lead;
import com.zohocrm.services.ContactService;
import com.zohocrm.services.LeadServices;



@Controller
public class LeadController {
	@Autowired
	private LeadServices leadServices;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewLead")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@PostMapping("/saveLead")
	public String saveOneLead(@ModelAttribute ("lead") Lead lead, Model model) {
		leadServices.saveOneLead(lead);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	@PostMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead= leadServices.findLeadById(id);
		Contacts contact=new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContact(contact);
		
		leadServices.deleteById(id);
		
		List<Contacts> contacts=contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "list_contacts";
	}
	@RequestMapping("/listall")
	public String listAllLeads(Model model) {
		List<Lead> leads = leadServices.getAllLeads();
		model.addAttribute("lead",leads);
		return "list_leads";
	}
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id,Model model) {
		Lead lead = leadServices.findLeadById(id);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
}
