/**
 * 
 */
package com.dao;

import java.sql.*;

import com.bean.User;
import com.controller.AES_encryption;
import com.controller.MD5_encryption;

/**
 * @author shaun
 *
 */
public class UpdateUserDAO {
	static Connection CurrentConnection = null;
	public static boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			Statement statement = null;
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			
			int user_id = user.getUser_id();
			String user_name = user.getUser_name();
			String email = user.getEmail();
			String password = user.getPassword();
			final String secretKey = "ssshhhhhhhhhhh!!!!";			
			password = AES_encryption.encrypt(password, secretKey);//Encrypting password.
			//String phone_number_country_code = user.getPhone_number_countrycode();
			String phone_number_country_code = "+1";
			String phone_number_main = user.getPhone_number_main();
			
			String update_user_query = "UPDATE `user` SET `user_name` = '"+user_name+"', "
					+ "`email`= '"+email+"', "
					+ "`password` = '"+password+"', "
					+ "`phone_number_country_code` = '"+phone_number_country_code+"', "
					+ "`phone_number_main` = '"+phone_number_main+"' WHERE `user`.`user_id` = '"+user_id+"'";
			
			int temp = statement.executeUpdate(update_user_query);
			System.out.println(temp);
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
