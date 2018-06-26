package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteReminderDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;
	public static boolean delete(int reminder_id) {
		Statement statement = null;
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			String deleteReminder = "DELETE from reminder WHERE reminder_id = '"+reminder_id+"'";
			succsess = statement.executeUpdate(deleteReminder);
			return true;
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
