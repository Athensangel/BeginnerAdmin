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
 * Servlet implementation class UserServletUpdate
 */
@WebServlet("/messageServletUpdate")
public class MessageServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageService messageService = new MessageServiceImpl();

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Message message = messageService.queryMessageById(Integer.parseInt(id));
		request.setAttribute("message", message);
		request.getRequestDispatcher("/views/message/messageUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String fromId = request.getParameter("fromId");
		String toId = request.getParameter("toId");
		String content = request.getParameter("content");
		String isRead = request.getParameter("isRead");
		Message message = new Message();
		message.setId(Integer.parseInt(id));
		message.setFromId(Integer.parseInt(fromId));
		message.setToId(Integer.parseInt(toId));
		message.setContent(content);
		message.setIsRead(isRead);
		messageService.updateMessageById(message);// 信息修改
		response.sendRedirect("messageServletList"); // 修改成功后跳转到信息列表页
	}

}
