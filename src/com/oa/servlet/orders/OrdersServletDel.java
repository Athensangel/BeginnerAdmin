package com.oa.servlet.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrdersService;
import service.impl.OrdersServiceImpl;

/**
 * Servlet implementation class UserServletDel
 */
/**
 * 删除订单
 * @author Administrator
 *
 */
@WebServlet("/orderstServletDel")
public class OrdersServletDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdersService orderstService = new OrdersServiceImpl();

	public OrdersService getOrderstService() {
		return orderstService;
	}

	public void setOrderstService(OrdersService orderstService) {
		this.orderstService = orderstService;
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServletDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toid = request.getParameter("toid");
		orderstService.deletOrdersById(Integer.parseInt(toid));
		//request.getRequestDispatcher("/orderstServletList").forward(request,response);
		response.sendRedirect("ordersServletList");// 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
