package com.dao;
// Refernce : https://www.twilio.com/blog/2014/04/add-sms-to-your-web-app-in-4-lines-of-code.html

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSUtility {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC49364a69d10e8f10a22d7a360fad6529";
  public static final String AUTH_TOKEN = "9a10c11252bbf29b6077db778e84e2a9";

  public static void sendSMS(String SMSto, String SMSmessage) {
	  try {
		  System.out.println("inside sms method");
		  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		  System.out.println("after init");
		    SMSto = "+15513585391";
		    
		    Message message = Message.creator(new PhoneNumber(SMSto),
		    		new PhoneNumber("+15187304710"), 
		        SMSmessage).create();

		    System.out.println(message.getSid());
		    System.out.println("sms sent");
		    
	} catch (Exception e) {
		System.out.println("exception" + e.getMessage());
	}
    
  }
}

