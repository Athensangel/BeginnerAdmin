package com.oa.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import service.impl.UserServiceimpl;

/**
 * Servlet implementation class UserServletList
 */

/**
 * 查看员工的列表
 * @author Administrator
 *
 */
@WebServlet("/userServletList")
public class UserServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  UserService userService = new UserServiceimpl();
       
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList= userService.findAllUsers();
		request.setAttribute("userList", userList);		//没有双引号字符类会报错
		request.getRequestDispatcher("/views/user/userList.jsp").forward(request, response);//跳转到那个页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
