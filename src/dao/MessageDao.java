package dao;

import java.util.List;

import model.Message;

public interface MessageDao {

	 public List<Message> findAllMessage();

	 public void InsertMessage(Message message);

	 public void delMessageById(Integer id);

	 public Message findMessageById(Integer id);

	 public void updateMessageById(Message message);

	 public void updateMessageInfo(Message message);

}
