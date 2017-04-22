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
 * Servlet implementation class UserServletSave
 */

/**
 * 添加员工信息
 * 
 * @author Administrator
 *
 */
@WebServlet("/departmentServletSave")
public class DepartmentServletSave extends HttpServlet {
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
	public DepartmentServletSave() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("views/department/departmentSave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentname = request.getParameter("departmentName");
		String managerid = request.getParameter("managerId");
		Department department = new Department();
		department.setDepartmentName(departmentname);
		department.setManagerId(Integer.parseInt(managerid));
		departmentService.saveDepartment(department); // 管理新增
		response.sendRedirect("departmentServletList");// 新增成功后跳转到管理列表页
	}

}
