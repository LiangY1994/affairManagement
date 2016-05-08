package com.DAO;

import java.util.List;
import com.util.bean.Reply;

public interface ReplyDAO {
	public void addReply(Reply m); // add a new Reply
	public void updateReply(Reply m, int updateID); // update a Reply
	public void deleteReply(int replyID); // delete a Reply
	public Reply findReply(int replyID); // find a Reply by id
	public List<Reply> findAllReply(); // find all Reply
}
