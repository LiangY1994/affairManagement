package com.DAO;

import com.util.Page;
import com.util.bean.*;
import java.util.List;

public interface MessageDAO {
	public void addMessage(Message m, String employeeName); // add a new reply
	public void updateMessage(Message m, String employeeName, int updateID); // update a reply
	public void deleteMessage(int messageID); // delete a reply
	public Message findMessage(int messageID); // find a reply by id
	public List<Message> findAllMessage(Page page); // find all reply
	public int findAmount(); // find the amount of replies
}
