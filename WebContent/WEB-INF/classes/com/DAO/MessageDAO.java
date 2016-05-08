package com.DAO;

import com.util.Page;
import com.util.bean.*;
import java.util.List;

public interface MessageDAO {
	public void addMessage(Message m, String employeeName); // add a new message
	public void updateMessage(Message m, String employeeName, int updateID); // update a message
	public void deleteMessage(int messageID); // delete a message
	public Message findMessage(int messageID); // find a message by id
	public List<Message> findAllMessage(Page page); // find all message
	public int findAmount(); // find the amount of messages
}
