package service;

import java.util.List;

import model.Message;

public interface MessageService {
	
	public List<Message> findAllMessage();// 遍历查询Product表中的字段

	public void saveMessage(Message message);// 新增信息

	public void deletMessageById(Integer id);// 通过toId查找信息信息并做删除处理

	public Message queryMessageById(Integer id);// 通过toId查找信息信息并做删除处理

	public void updateMessageById(Message message);// 查找信息，并修改信息信息

	public void updateMessageInfo(Message message);// 更改信息信息
}
