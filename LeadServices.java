package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entities.Lead;


public interface LeadServices {
    public void saveOneLead(Lead lead);

	public Lead findLeadById(long id);

	public void deleteById(long id);

	public List<Lead> getAllLeads();
}
