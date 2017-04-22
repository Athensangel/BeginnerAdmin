package com.oa.servlet.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;
import service.impl.MessageServiceImpl;

/**
 * Servlet implementation class UserServletSave
 */

/**
 * 添加员工信息
 * 
 * @author Administrator
 *
 */
@WebServlet("/messageServletSave")
public class MessageServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MessageService messageService=new MessageServiceImpl();

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServletSave() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("views/message/messageSave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fromId = request.getParameter("fromId");
		String toId = request.getParameter("toId");
		String content = request.getParameter("content");
		String isRead = request.getParameter("isRead");
		Message message = new Message();
		message.setFromId(Integer.parseInt(fromId));;
		message.setToId(Integer.parseInt(toId));
		message.setContent(content);
		message.setIsRead(isRead);
		messageService.saveMessage(message);// 产品新增
		response.sendRedirect("messageServletList");// 新增成功后跳转到产品列表页
	}

}
