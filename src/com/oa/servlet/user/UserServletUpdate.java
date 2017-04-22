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
 * Servlet implementation class UserServletUpdate
 */
@WebServlet("/UserServletUpdate")
public class UserServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceimpl();
       
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toid = request.getParameter("toid");
		User user = userService.queryUserById(Integer.parseInt(toid));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/views/user/userUpdate.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toid = request.getParameter("toid");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String realname = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String telphone = request.getParameter("telphone");
		String qq = request.getParameter("qq");
		String salary = request.getParameter("salary");
		String departId = request.getParameter("departId");
		String role = request.getParameter("role");
		User user = new User();
		user.setToid(Integer.parseInt(toid));
		user.setPassWord(password);
		user.setUserName(username);
		user.setRealName(realname);
		user.setSex(sex);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setAddress(address);
		user.setQq(qq);
		user.setTelphone(telphone);
		user.setSalary(Float.parseFloat(salary));
		user.setDepartId(Integer.parseInt(departId));
		user.setRole(role);
		userService.updateUserByID(user); //员工修改
		response.sendRedirect("userServletList"); //修改成功后跳转到员工列表页
	}

}
