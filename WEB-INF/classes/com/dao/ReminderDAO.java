package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import;

public class ReminderDAO implements Runnable{
	static Connection CurrentConnection = null;
	static ResultSet resultset = null;
	@SuppressWarnings("deprecation")
	@Override
    public void run() {
		Statement statement = null;	
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			
			Date d1 = new Date();
			Date d2 = new Date();
			d2.setMinutes(d1.getMinutes() + 1);
			SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String currentTime = df.format(d1);
			String nextTime = df.format(d2);
			System.out.println("It Ran on : " + currentTime);
			System.out.println("A minute from now is : " + nextTime);
			
		   
		   // EmailUtility.sendEmail(host, port, user, pass, "shaunaksangdod@gmail.com", "Reminder", "content");
		   //System.out.println("-------------------");
			String searchQuery = "SELECT collaborators.user_id,user.email,reminder.* "
					+ "FROM collaborators INNER JOIN reminder on collaborators.note_id = reminder.note_id INNER JOIN user ON collaborators.user_id = user.user_id "
					+ "WHERE reminder.time BETWEEN '"+currentTime+"' AND '"+nextTime+"'" ;
			
			resultset = statement.executeQuery(searchQuery);
			
			while(resultset.next()){
				//EmailSendingServlet e = new EmailSendingServlet();
				//System.out.println(e.host);
				if(resultset.getString(7) == "1")
				{
				System.out.println("trying to send mail to : " + resultset.getString(2));
				EmailUtility.sendEmail(resultset.getString(2), "Reminder",resultset.getString(8));
				System.out.println("reminder email sent to" + resultset.getString(2));
				}else{
					System.out.println("trying to send a message");
					SMSUtility.sendSMS("",resultset.getString(8) );
					System.out.println("reminder message sent");
				}
			}
		} catch (Exception e) {
				System.out.println("Exception:" + e);
		}
		
		
		
		
    }
}
