package com.edubridge.contact_app;

import java.util.List;
import java.util.Scanner;

import com.edubridge.contact_app.dao.ContactDaoImpl;
import com.edubridge.contact_app.model.Contact;
import com.edubridge.contact_app.dao.ContactDao;



public class App 
{
    public static void main( String[] args )
    {
    	ContactDao dao = new ContactDaoImpl();
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.println("MY CONTACT APP");
        	System.out.println("1.ADD All CONTACT");
        	System.out.println("2.VIEW CONTACT");
        	System.out.println("3.SEACRCH CONTACT");
        	System.out.println("4.UPDATE CONTACT");
        	System.out.println("5.DELETE CONTACT");
        	System.out.println("PLEASE CHOOSE OPTION:");
        	int option = in.nextInt();
        	
        	switch (option) {
        	case 1:
        		
        		System.out.println("Please enter contact name:");
        		String name = in.next();
        		System.out.println("Please enter contact email:");
        		String email = in.next();
        		System.out.println("Please enter contact mobile:");
        		long mobile = in.nextLong();
        		
        		Contact newContact = new Contact();
        		newContact.setName(name);
        		newContact.setEmail(email);
        		newContact.setMobile(mobile);
        		
        		int status = dao.addContact(newContact);
        		if(status>= 1) {
        			System.out.println("New Contact Saved!!!");
        		}else {
        			System.out.println("Something is Wrong!!!");
        		}
        		break;
        	case 2:

    		List<Contact> contacts=dao.getAllContacts();
			if(contacts.size() != 0) {
				for(Contact c : contacts) {
					System.out.println(c.getId()+"\t"+c.getName()+"\t"+c.getEmail()+"\t"+c.getMobile());
				}
			}else {
				System.out.println("no contacts found");
				}
        		break;
        	case 0:
        		System.out.println("Bye!!");
        		break;
        	default:
        		System.out.println("invalid Option!!!");
        		break;
        		
        	}
        	
        }
    }
}
