package com.util.bean;

import java.util.Date;

public class Message {
	private int messageID;
	private String messageTitle;
	private Date messageDate;
	private String messageContent;
	private String employeeName;
	public int getMessageID(){ // get message id
		return messageID;
	}
	public void setMessageID(int id){ // set message id
		messageID = id;
	}
	public String getMessageTitle(){
		return messageTitle;
	}
	public void setMessageTitle(String title){
		messageTitle = title;
	}
	public Date getMessageDate(){ // get message date
		return messageDate;
	}
	public void setMessageDate(Date date){ // set message date
		messageDate = date;
	}
	public String getMessageContent(){ // get message content
		return messageContent;
	}
	public void setMessageContent(String content){ // set message content
		messageContent = content;
	}
	public String getEmployeeName(){ // get name of publisher
		return employeeName;
	}
	public void setEmployeeName(String name){ // set name of publisher
		employeeName = name;
	}
}
