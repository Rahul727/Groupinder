package com.dao;

import com.bean.Reminder;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.dao.DbConnection;
public class EditReminderDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;
	public static boolean edit(Reminder new_reminder) {
		Statement statement = null;
		
		
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			String updateReminder = "UPDATE reminder SET time ='"+new_reminder.date+"', message = '"+new_reminder.message+"' "
					+ "WHERE reminder_id = '"+new_reminder.reminder_id+"'";
			succsess = statement.executeUpdate(updateReminder);
			return true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

}
