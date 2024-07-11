package com.edubridge.contact_app.dao;

import java.util.List;

import com.edubridge.contact_app.model.Contact;

public interface ContactDao {
	 int addContact(Contact c);
	 List<Contact> getAllContacts();
	 Contact getContact(String name);
	 int updateContact(Contact c);
	 int deleteContact(String name);
	 void deleteAllContacts();
	 

}
