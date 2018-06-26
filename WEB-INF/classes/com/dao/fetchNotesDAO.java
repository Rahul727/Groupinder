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
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Note;
import com.bean.User;

/**
 * @author shaun
 *
 */
public class fetchNotesDAO {
	static Connection CurrentConnection = null;
	static ResultSet resultset = null,resutltsetContents = null,resutltsetCollaborators = null;
	static ResultSet resultset_lable=null;
	 
	
	public static ArrayList<Note> fetch(User current_user, ArrayList<Note> notes, String note_label, String search_key) {
		Statement statement = null,statementContents = null,statementCollaborators = null;	
		String searchNotes,searchNoteContents,searchCollaborators;
		int userID = current_user.getUser_id();
		//String searchNotes = "select `note_id` from collaborators" + " where user_id= '"+userID+"'";
		try {
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			statementContents = CurrentConnection.createStatement();
			statementCollaborators = CurrentConnection.createStatement();
			//sub query used to fetch all the notes required. then all the data is fetched.
			/*
			String searchNotes ="SELECT note.note_id,note.pin_status,note.title,note_contents.list_id,note_contents.contents,note_lable.lable"+
			" FROM `note` INNER JOIN `note_contents` ON `note`.`note_id` = `note_contents`.`note_id` INNER JOIN `note_lable` ON note.note_id = note_lable.note_id"+
			" WHERE `note`.`note_id` IN (SELECT collaborators.note_id "+
			" FROM collaborators WHERE collaborators.user_id = '"+userID+"')";
			 */
			
			if(note_label != null){
				searchNotes ="SELECT note.note_id,note.pin_status,note.title,note_lable.lable"+
						" FROM `note` INNER JOIN `note_lable` ON note.note_id = note_lable.note_id"+
						" WHERE `note`.`note_id` IN (SELECT collaborators.note_id "+
						" FROM collaborators WHERE collaborators.user_id = '"+userID+"') AND note_lable.lable = '"+note_label+"'";
				
				searchNoteContents ="SELECT note.note_id,note_contents.contents"+
						" FROM `note` INNER JOIN `note_contents` ON `note`.`note_id` = `note_contents`.`note_id`"+
						" WHERE `note`.`note_id` IN (SELECT collaborators.note_id "+
						" FROM collaborators WHERE collaborators.user_id = '"+userID+"')";	
				
			}else{
				searchNotes ="SELECT note.note_id,note.pin_status,note.title,note_lable.lable"+
						" FROM `note` INNER JOIN `note_lable` ON note.note_id = note_lable.note_id"+
						" WHERE `note`.`note_id` IN (SELECT collaborators.note_id "+
						" FROM collaborators WHERE collaborators.user_id = '"+userID+"')";
				
				searchNoteContents ="SELECT note.note_id,note_contents.contents"+
						" FROM `note` INNER JOIN `note_contents` ON `note`.`note_id` = `note_contents`.`note_id`"+
						" WHERE `note`.`note_id` IN (SELECT collaborators.note_id "+
						" FROM collaborators WHERE collaborators.user_id = '"+userID+"')";
			}
				searchCollaborators = "SELECT a.*,user.user_name FROM `collaborators` as a INNER JOIN `collaborators` as b INNER JOIN user ON b.user_id = user.user_id "
						+ "WHERE a.user_id = '"+userID+"' AND a.user_id <> b.user_id AND b.note_id = a.note_id";
			resultset = statement.executeQuery(searchNotes);
			resutltsetContents = statementContents.executeQuery(searchNoteContents);
			resutltsetCollaborators = statementCollaborators.executeQuery(searchCollaborators);


			
			while (resultset.next()){
				ArrayList<String> content = new ArrayList<>();	
				ArrayList<String> collaborators = new ArrayList<>();	
				Note note = new Note();
				System.out.println("-------------------------------");
				
				System.out.println("noteID     : " + resultset.getInt(1));
				note.setNoteID(resultset.getInt(1));
				
				System.out.println("pin status :" + resultset.getInt(2));
				note.setPinStatus(resultset.getInt(2));
				
				System.out.println("title      :" + resultset.getString(3));
				note.setTitle(resultset.getString(3));
				
				//System.out.println("list_id    :" + resultset.getInt(4));
				//note.setListID(resultset.getInt(4));
				
				//System.out.println("contents   :" + resultset.getString(5));
				//note.setContent(resultset.getString(5));
				
				while(resutltsetContents.next()){		
					//System.out.println("resutltsetContents.getInt(1) : " + resutltsetContents.getInt(1) + "resultset.getInt(1):" + resultset.getInt(1));
					if (resutltsetContents.getInt(1) == resultset.getInt(1)){
						content.add(resutltsetContents.getString(2));	
					}
				}
				note.setContent(content);
				System.out.println("content " + content);
				
				
				while(resutltsetCollaborators.next()){
					if (resutltsetCollaborators.getInt(1) == resultset.getInt(1)){
						collaborators.add(resutltsetCollaborators.getString(4));	
					}
				}
				note.setCollaborators(collaborators);
				System.out.println("collaborators " + collaborators);
				
				System.out.println("label   :" + resultset.getString(4));
				note.setLabel(resultset.getString(4));
				System.out.println("-------------------------------");
				
				if(search_key != null){
					if(note.title.contains(search_key) || note.content.contains(search_key))
						notes.add(note);
				}else{
					notes.add(note);
				}
								
				resutltsetContents.first();
				resutltsetCollaborators.first();
			}



			
		} catch (Exception e) {
			System.out.println("Notes can not be fetched.");
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
		
		
		return notes;
	}

}
