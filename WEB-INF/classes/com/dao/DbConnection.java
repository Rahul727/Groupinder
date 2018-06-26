/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
 * Last modified: 
 * version 7
 * Groupinder Web-application.
 * References:
 	
 */


/**
 * 
 */
package com.dao;

import java.sql.*;
/**
 * @author Team 7
 * 
 *
 */
public class DbConnection {
	
	/**
	 * @param args
	 */
	public static Connection connect = null;


	public static Connection getConnection() {
		// Statement statement = null;
		 String host = "localhost", user = "root", password = "";
		// ResultSet resultSet = null;
		 
		try{
			
			      // This will load the MySQL driver, each DB has its own driver
			      Class.forName("com.mysql.jdbc.Driver").newInstance();
			      
			      // Setup the connection with the DB
			      connect = 
			    		  DriverManager
			          .getConnection("jdbc:mysql://" + host + "/groupinder?"
			              + "user=" + user + "&password=" + password );

		}catch (Exception e) {
			   System.out.println("SQLException: " + e.getMessage());
	            
		}
		finally{
			/*
				try {
					if(connect!= null){
					//connect.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
		}

		return connect;
	}

}
