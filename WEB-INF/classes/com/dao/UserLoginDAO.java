/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved.
 * Date written: 
 * Last modified: 
 * version 7
 * Groupinder Web-application.
 * References:
 	
 */

package com.dao;

import java.sql.*;
import org.apache.catalina.valves.CometConnectionManagerValve;
import java.util.*;
import com.bean.User;
import com.dao.DbConnection;
import com.controller.AES_encryption;
import com.controller.MD5_encryption;

public class UserLoginDAO {

	static Connection CurrentConnection = null;
	static ResultSet resultset = null;
	
	public static User login(User current_user){
		Statement statement = null;		
		String userName = current_user.getUser_name();
		String password = current_user.getPassword();
		final String secretKey = "ssshhhhhhhhhhh!!!!";			
		password = AES_encryption.encrypt(password, secretKey);//Encrypting password.
		
		String searchQuery = "select * from user"
				           + " where email= '"+userName+"' and password= '"+password+"' ";
		
		try{
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			resultset = statement.executeQuery(searchQuery);
			
			boolean user_available = resultset.next();
			
			if(!user_available){
				System.out.println("User with this combination not found.");
	            current_user.setValid(false);
			}else{
				// set user details
				//current_user.user_name = searchQuery.
				current_user.user_id = resultset.getInt("user_id");
				current_user.phone_number_main = resultset.getString("phone_number_main");
				current_user.phone_number_countrycode = resultset.getString("phone_number_country_code");
				current_user.user_name = resultset.getString("user_name");
				current_user.email = resultset.getString("email");	
				current_user.setValid(true);
			}
		}catch (Exception e) {
			System.out.println("login failed.");
			System.out.println(e.getMessage());
		}
		//closing connections
		finally{
			if(resultset!= null){
				try {
					resultset.close();
				} catch (Exception e2) {
					resultset = null;
				}
			}
			
			if(statement!= null){
				try {
					statement.close();
				} catch (Exception e2) {
					statement = null;
				}
			}
			
			if(CurrentConnection!= null){
				try {
					CurrentConnection.close();
				} catch (Exception e2) {
					CurrentConnection = null;
				}
			}
		}
		return current_user;
	
	}
}
