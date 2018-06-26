package com.bean;



public class Reminder {
	public int reminder_id,note_id;
	/**
	 * @return the note_id
	 */
	public int getNote_id() {
		return note_id;
	}
	/**
	 * @param note_id the note_id to set
	 */
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String hours;
	public String minutes;
	public String seconds;
	public String note_title;
	public String date;
	public String y,m,d; //for calendar
	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(String y) {
		this.y = y;
	}
	/**
	 * @return the m
	 */
	public String getM() {
		return m;
	}
	/**
	 * @param m the m to set
	 */
	public void setM(String m) {
		this.m = m;
	}
	/**
	 * @return the d
	 */
	public String getD() {
		return d;
	}
	/**
	 * @param d the d to set
	 */
	public void setD(String d) {
		this.d = d;
	}
	/**
	 * @return the note_title
	 */
	public String getNote_title() {
		return note_title;
	}
	/**
	 * @param note_title the note_title to set
	 */
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getSeconds() {
		return seconds;
	}
	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getMinutes() {
		return minutes;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String medium;
	public String message;
	boolean isReminderCreate;
	public boolean isReminderCreate() {
		return isReminderCreate;
	}
	public void setReminderCreate(boolean isReminderCreate) {
		this.isReminderCreate = isReminderCreate;
	}
	public int getReminder_id() {
		return reminder_id;
	}
	public void setReminder_id(int reminder_id) {
		this.reminder_id = reminder_id;
	}

	
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
