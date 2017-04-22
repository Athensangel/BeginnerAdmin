package com.oa.servlet.orders;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Orders;
import service.OrdersService;
import service.impl.OrdersServiceImpl;

/**
 * Servlet implementation class UserServletList
 */

/**
 * 查看订单的列表
 * @author Administrator
 *
 */
@WebServlet("/ordersServletList")
public class OrdersServletList extends HttpServlet {
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
    public OrdersServletList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orders> ordersList=orderstService.findAllOrders();
		request.setAttribute("ordersList", ordersList);		//没有双引号字符类会报错
		request.getRequestDispatcher("/views/orders/ordersList.jsp").forward(request, response);//跳转到那个页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
