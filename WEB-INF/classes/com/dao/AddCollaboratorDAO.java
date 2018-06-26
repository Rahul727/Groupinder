package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.bean.User;

public class AddCollaboratorDAO {

	static Connection CurrentConnection = null;
	static ResultSet resultset = null;
	static int succsess = 0;

	public static boolean add(String email, String noteID) {
		// If the user already exists, simply add. otherwise send a registration request.
		Statement statement = null;	
		String checkUser = "SELECT user_id FROM user WHERE email = '"+email+"'";
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			resultset = statement.executeQuery(checkUser);
			
			boolean user_available = resultset.next(); 
			
			if(user_available){
				String addCollaborator = "INSERT INTO collaborators VALUES ('"+noteID+"','"+resultset.getInt(1)+"','1')"; //1 = edit permission
				succsess = statement.executeUpdate(addCollaborator);
				return true;
			}else{
				System.out.println("adding new user");
				User new_user = new User();
				new_user.setEmail(email);
				new_user.setPassword("Temp@123");
				new_user.setUser_name("new_user");
				UserRegistrationDAO.register(new_user);
				if(new_user.isRegistered()){
					System.out.println("Sending mail to new user");
					try {
						EmailUtility.sendEmail(new_user.email, "Cheers! ",
						        "Welcome, "+ new_user.email +"\n "
						        		+ "you're all set, Start Noting! \n "
						        		+ "Sign in with your Email. Your password is : Temp@123. We highly recommend to change it ASAP."
						        		+ "\n Thanks,\n Team Groupiner");
						System.out.println("Mail sent to new user.");
					} catch (AddressException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

}
