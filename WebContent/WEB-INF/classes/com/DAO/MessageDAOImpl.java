package com.DAO;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.util.DBConnection;
import com.util.Page;
import com.util.bean.Message;

public class MessageDAOImpl implements MessageDAO{

	@Override
	public void addMessage(Message m, String employeeName) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		java.sql.PreparedStatement prtsmt = null;
		String query = "insert into tb_message(messageDate, messageContent, employeeName, messageTitle)"
				+ " values(?, ?, ?, ?)";
		try{
			prtsmt = connection.prepareStatement(query);
			java.util.Date utilDate = m.getMessageDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			prtsmt.setDate(1, sqlDate); // set parameters of a message
			prtsmt.setString(2, m.getMessageContent());
			prtsmt.setString(3, employeeName);
			prtsmt.setString(4, m.getMessageTitle());
			prtsmt.executeUpdate(); // execute query
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateMessage(Message m, String employeeName, int updateID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		java.sql.PreparedStatement prtsmt = null;
		String query = "update tb_message set messageDate=? and messageContent=? and employeeName=?"
					+ " and messageTitle = ? where messageID = ?";
		try{
			prtsmt = connection.prepareStatement(query);
			java.util.Date utilDate = m.getMessageDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			prtsmt.setDate(1, sqlDate); // set parameters of a message
			prtsmt.setString(2, m.getMessageContent());
			prtsmt.setString(3, employeeName);
			prtsmt.setString(4, m.getMessageTitle());
			prtsmt.setInt(5, updateID);
			prtsmt.executeUpdate(); // execute query
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMessage(int messageID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		java.sql.PreparedStatement prtsmt = null;
		String query = "delete from tb_message where messageID = ?";
		try{
			prtsmt = connection.prepareStatement(query);
			prtsmt.setInt(1, messageID);
			prtsmt.executeUpdate(); // execute query
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Message findMessage(int messageID){
		// TODO Auto-generated method stub
		Message message = new Message();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			String query = "select * from tb_message where messageID = ?"; // initialization
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, messageID);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){ // find a message correspond
				message.setMessageID(resultSet.getInt(1)); // set parameters
				java.util.Date dateTemp = new Date(resultSet.getDate(2).getTime());
				message.setMessageDate(dateTemp);
				message.setMessageContent(resultSet.getString(3));
				message.setEmployeeName(resultSet.getString(4));
				message.setMessageTitle(resultSet.getString(5));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return message;
	}

	@SuppressWarnings("null")
	@Override
	public List<Message> findAllMessage(Page page) {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>();
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			int sqlOffset = page.getCurrentPage() - 1;
			sqlOffset *= page.getEachPage();
			int sqlSum = page.getEachPage();
			String query = "select * from tb_message order by messageDate desc limit ?,?"; // initialization
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, sqlOffset);
			preparedStatement.setInt(2, sqlSum);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){ // find a message correspond
				Message message = new Message();
				message.setMessageID(resultSet.getInt(1)); // set parameters
				java.util.Date dateTemp = new Date(resultSet.getDate(2).getTime());
				message.setMessageDate(dateTemp);
				message.setMessageContent(resultSet.getString(3));
				message.setEmployeeName(resultSet.getString(4));
				message.setMessageTitle(resultSet.getString(5));
				messages.add(message); // add a message into the list
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return messages;
	}

	@Override
	public int findAmount() {
		int amount = 0; // initialization
		Connection connection = DBConnection.getConnection();
		String query = "select * from tb_message";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){ // get id of the last message
				amount = resultSet.getInt(1); // last id is the amount of messages
			}
		}catch(Exception e){
			e.printStackTrace(); // catch exception
		}
		return amount;
	}
}
