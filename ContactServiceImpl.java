package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Contacts;
import com.zohocrm.repositories.ContactRepository;


@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public void saveContact(Contacts contact) {
		contactRepo.save(contact);
	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> con = contactRepo.findAll();
		return con;
	}

	@Override
	public Contacts getContactById(long id) {
		Optional<Contacts> findId = contactRepo.findById( id);
		Contacts con=findId.get();
		return con;
	}
	

}
