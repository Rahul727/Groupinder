package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import com.bean.*;

public class FetchReminderDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null;
	public static ArrayList<Reminder> FetchReminders(User current_user){
		Statement statement = null;
		int userID = current_user.getUser_id();
		ArrayList<Reminder> view_reminders=new ArrayList<Reminder>();
		try{
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			
			String searchReminders="SELECT note.note_id,note.title,reminder.time,reminder.medium,reminder.message,reminder.reminder_id "
					+ "FROM `reminder` INNER JOIN `note` ON reminder.note_id=note.note_id "
					+ "INNER JOIN `collaborators` ON collaborators.note_id=reminder.note_id "
					+ "WHERE collaborators.user_id='"+userID+"'";
			resultset= statement.executeQuery(searchReminders);
			
			while(resultset.next()){
				Reminder reminder = new Reminder();
				reminder.setReminder_id(resultset.getInt(6));
				reminder.setNote_id(resultset.getInt(1));
				reminder.setNote_title(resultset.getString(2));
				reminder.setMedium(resultset.getString(4));
				reminder.setMessage(resultset.getString(5));
				String[] parts = resultset.getString(3).split(" ");
				String date = parts[0] +"T"+ parts[1];
				reminder.setDate(date);
				view_reminders.add(reminder);
			}
			
			
			
		}
		catch (Exception e) {
			System.out.println("Reminders can not be fetched.");
			System.out.println(e.getMessage());
			
		}
		
		//closing connections
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
		
		return view_reminders;
	}
}
