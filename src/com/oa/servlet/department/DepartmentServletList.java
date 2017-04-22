package com.oa.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class UserServletList
 */

/**
 * 查看员工的列表
 * @author Administrator
 *
 */
@WebServlet("/departmentServletList")
public class DepartmentServletList extends HttpServlet {
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
    public DepartmentServletList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> departmentList= departmentService.findAllDepartment();
		request.setAttribute("departmentList", departmentList);		//没有双引号字符类会报错
		request.getRequestDispatcher("/views/department/departmentList.jsp").forward(request, response);//跳转到那个页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
