package com.oa.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class UserServletDel
 */
@WebServlet("/departmentServletDel")
public class DepartmentServletDel extends HttpServlet {
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
    public DepartmentServletDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toid = request.getParameter("toid");
		departmentService.deletDepartmentById(Integer.parseInt(toid));
		request.getRequestDispatcher("/departmentServletList").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
