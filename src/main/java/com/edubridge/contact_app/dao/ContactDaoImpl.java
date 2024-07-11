package com.edubridge.contact_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.contact_app.model.Contact;
import com.edubridge.contact_app.util.DBUtils;


public class ContactDaoImpl implements ContactDao  {

	@Override
	public int addContact(Contact c) {
		String INSERT = "insert into contact(name,email,mobile) values(?,?,?)";
			Connection con =DBUtils.getConnection();
			int status=0;
			try {
				PreparedStatement ps=con.prepareStatement(INSERT);
				ps.setString(1,c.getName());
				ps.setString(2,c.getEmail());
				ps.setLong(3,c.getMobile());
				status=ps.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return status;
	}

	@Override
	public List<Contact> getAllContacts() {
		String SELECT = "select * from contact";
	   Connection con= DBUtils.getConnection();
	   List<Contact>contact=new ArrayList<Contact>();
	   
		try {
			PreparedStatement ps = con.prepareStatement(SELECT);
			ResultSet rs =ps.executeQuery();
		
			while(rs.next()){
				Contact c =new Contact ();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setMobile(rs.getLong("mobile"));
						contact.add(c);
				
			}
		}
	catch (SQLException e) {
		e.printStackTrace();
	}
		return contact;
	}

	private void While(boolean next) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contact getContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateContact(Contact c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteContact(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAllContacts() {
		// TODO Auto-generated method stub
		
	}

}
