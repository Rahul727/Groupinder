package com.dao;

import com.dao.DbConnection;
import java.sql.*;
/**
 * @author shaun
 *
 */
public class DeleteNoteDAO {
	static Connection CurrentConnection = null;
	static int succsess = 0;
	
	public static boolean deleteNote(String noteID){
		String DeletenNotelabel = "DELETE FROM `note_lable` WHERE `note_id` = '"+noteID+"'";
		String DeletenNoteContents = "DELETE FROM `note_contents` WHERE `note_id` = '"+noteID+"'";
		String DeletenNoteCollaborators = "DELETE FROM `collaborators` WHERE `note_id` = '"+noteID+"'";
		String DeletenNoteEntry = "DELETE FROM `note` WHERE `note_id` = '"+noteID+"'";
		try {
			Statement statement = null;
			CurrentConnection = DbConnection.getConnection();
			statement = CurrentConnection.createStatement();
			statement.executeUpdate(DeletenNotelabel);
			statement.executeUpdate(DeletenNoteContents);
			statement.executeUpdate(DeletenNoteCollaborators);
			statement.executeUpdate(DeletenNoteEntry);
			return true;
		} catch (Exception e) {
			System.out.println("Note deletion can not be done.");
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}
}
