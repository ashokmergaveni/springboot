package com.in28minutes.springboot.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.in28minutes.springboot.web.controller.User;
public class CamdenDb {
	public List<User>  getUserDetails() throws SQLException, ClassNotFoundException
	{
	Class.forName("org.postgresql.Driver");
   List<User> lu=new ArrayList<User>();

	 //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres") ;
	   Connection connection = DriverManager.getConnection("jdbc:postgresql://awsnlcld001.amwaternp.net:5432/ao-aw-camden", "postgres", "vjedqz)D6kd") ;
	 
	Statement st= connection.createStatement();
	//select email from login where username='ashok'
	ResultSet rs=st.executeQuery("select * from  app.hqo_company_events where NOT \"isApproved\"='yes'");
	while(rs.next())
	{
		User user = new User();
		System.out.println(rs.getString("name"));
		user.setName(rs.getString("name"));
		user.setVenue(rs.getString("venue"));
		user.setAlert_type(rs.getString("alert_type"));
		user.setDescription(rs.getString("description"));
		user.setEventId(rs.getLong("event_id"));
		lu.add(user);
	}
	return lu;
	}
	public Integer updateEventState(Integer eventId) throws SQLException, ClassNotFoundException
	{
	Class.forName("org.postgresql.Driver");
	String s=null;
	 Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres") ;
	 
	Statement st= connection.createStatement();
	//select email from login where username='ashok'
	System.out.println(eventId+"<td>${todo.venue}</td><td>${todo.venue}</td><td>${todo.venue}</td>");
	String query="update  app.hqo_company_events set \"isApproved\"='yes' where event_id="+eventId;
	
	int rs=st.executeUpdate(query);
	connection.commit();
	
	return rs;
	}
}