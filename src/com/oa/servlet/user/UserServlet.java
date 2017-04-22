package com.oa.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServiceimpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserService userService=new UserServiceimpl(); 
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("table.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sUserName = request.getParameter("userName");
		String sPasswd = request.getParameter("passWord");
		System.out.println("username:" + sUserName + "\r\n" + "password:" + sPasswd);

		User user = userService.checkUserLogin(sUserName, sPasswd);
		if (sUserName.equals(user.getUserName()) && sPasswd.equals(user.getPassWord())) {//判断输入的用户名和密码和数据库的是否一样，跳到主页
			response.sendRedirect("index.jsp");
			request.getSession().setAttribute("UserName", sUserName);
			request.getSession().setAttribute("password", sPasswd);
			request.getSession().setAttribute("toid", user.getToid());
		} else {
			response.sendRedirect("login.jsp");//输入的用户名密码和数据库不匹配，跳回登陆页
		}
				
	}

}
