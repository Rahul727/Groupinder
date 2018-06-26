package com.dao;

import java.sql.*;
import java.util.Set;
import java.util.TreeSet;

import org.apache.tomcat.jni.Time;

import com.bean.Note;
import com.bean.Reminder;
public class CreateReminderDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset_ = null;
	static Statement statement = null;
	
	public static Reminder create(Reminder new_reminder){
		
		int list_id=0;
		String date=new_reminder.getDate();
		String medium=new_reminder.getMedium();
		String message=new_reminder.getMessage();
		int note_id = new_reminder.getNote_id();
		
		try{
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			
			String insertQuery= "INSERT INTO `reminder` VALUES( NULL,'"+note_id+"','"+list_id+"','"+date+"','"+medium+"','"+message+"');";
			statement.execute(insertQuery);
			new_reminder.setReminderCreate(true);
		}catch (Exception e) {
			new_reminder.setReminderCreate(false);
			System.out.println("Reminder Creation can not be done.");
			System.out.println(e.getMessage());
		}
		finally{
			
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
		return new_reminder;
		
	}
}
