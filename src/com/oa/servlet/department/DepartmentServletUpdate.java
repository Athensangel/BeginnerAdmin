package com.oa.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class UserServletUpdate
 */
@WebServlet("/departmentServletUpdate")
public class DepartmentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartmentService departmentService = new DepartmentServiceImpl();

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toid = request.getParameter("toid");
		Department department = departmentService.queryDepartmentById(Integer.parseInt(toid));
		request.setAttribute("department", department);
		request.getRequestDispatcher("/views/department/departmentUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toid = request.getParameter("toId");
		String departmentname = request.getParameter("departmentName");
		String managerid = request.getParameter("managerId");
		Department department = new Department();
		department.setToId(Integer.parseInt(toid));
		department.setDepartmentName(departmentname);
		department.setManagerId(Integer.parseInt(managerid));;
		departmentService.updateDepartmentById(department);// 产品修改
		response.sendRedirect("departmentServletList"); // 修改成功后跳转到产品列表页
	}

}
