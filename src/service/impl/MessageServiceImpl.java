package service.impl;

import java.util.List;

import dao.MessageDao;
import dao.impl.MessageDaoImpl;
/**
 *MessageService实现的接口，为Dao层提供接口
 * @author Administrator
 *
 */
import model.Message;
import service.MessageService;

public class MessageServiceImpl implements MessageService {
	public MessageDao MessageDao =new MessageDaoImpl(); 
	
	public MessageDao getMessageDao() {
		return MessageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		MessageDao = messageDao;
	}

	@Override
	public List<Message> findAllMessage() {
		return MessageDao.findAllMessage();
	}

	@Override
	public void saveMessage(Message message) {
		MessageDao.InsertMessage(message);
	}

	@Override
	public void deletMessageById(Integer id) {
		MessageDao.delMessageById(id);
	}

	@Override
	public Message queryMessageById(Integer id) {
		return MessageDao.findMessageById(id);
	}

	@Override
	public void updateMessageById(Message message) {
		MessageDao.updateMessageById(message);
	}

	@Override
	public void updateMessageInfo(Message message) {
		MessageDao.updateMessageInfo(message);
	}

}
