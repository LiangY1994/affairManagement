package com.DAO;

public class MessageDAOFactory {
	public static MessageDAO getMessageDAOInstance(){
		return new MessageDAOImpl(); // get an example of MessageDAO
	}
}
