package com.oa.servlet.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;
import service.impl.MessageServiceImpl;

/**
 * Servlet implementation class UserServletList
 */

/**
 * 查看员工的列表
 * @author Administrator
 *
 */
@WebServlet("/messageServletList")
public class MessageServletList extends HttpServlet {
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
    public MessageServletList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Message> messageList= messageService.findAllMessage();
		request.setAttribute("messageList", messageList);		//没有双引号字符类会报错
		request.getRequestDispatcher("/views/message/messageList.jsp").forward(request, response);//跳转到那个页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
