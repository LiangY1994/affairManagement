package com.DAO;

import java.sql.Connection;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.util.DBConnection;
import com.util.bean.Reply;

public class ReplyDAOImply implements ReplyDAO {

	@Override
	public void addReply(Reply m) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String query = "insert into tb_reply(replyID, replyDate, replyContent, employeeID, messageID)"
					+ " values(?, ?, ?, ?, ?)";
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateReply(Reply m, int updateID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(int replyID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reply findReply(int replyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reply> findAllReply() {
		// TODO Auto-generated method stub
		return null;
	}

}
