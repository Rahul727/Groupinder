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
package com.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shaun
 *
 */
public class MD5_encryption {
	private static MessageDigest md;

	   public static String cryptWithMD5(String pass){
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        System.out.println("Encryption can not be done. Exception Occured!");
	    }
	        return null;


	   }

}
