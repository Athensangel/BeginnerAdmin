package com.oa.servlet.orders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Orders;
import service.OrdersService;
import service.impl.OrdersServiceImpl;

/**
 * Servlet implementation class UserServletSave
 */

/**
 * 添加订单信息
 * 
 * @author Administrator
 *
 */
@WebServlet("/ordersServletSave")
public class OrdersServletSave extends HttpServlet {
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
	public OrdersServletSave() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("views/orders/ordersSave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custname = request.getParameter("custName");
		String custaddress = request.getParameter("custAddress");
		String custphone = request.getParameter("custPhone");
		String custemail = request.getParameter("custEmail");
		String odertime = request.getParameter("oderTime");
		String productid = request.getParameter("productId");
		String productcount = request.getParameter("productCount");
		String money=request.getParameter("money");
		String createtime = request.getParameter("createTime");
		String userid = request.getParameter("userId");
		Orders orders = new Orders();
		orders.setCustName(custname);
		orders.setCustAddress(custaddress);
		orders.setCustPhone(custphone);
		orders.setCustEmail(custemail);
		orders.setOderTime(odertime);
		orders.setProductId(Integer.parseInt(productid));
		orders.setProductCount(Integer.parseInt(productcount));
		orders.setMoney(Float.parseFloat(money));
		orders.setCreateTime(createtime);
		orders.setUserId(Integer.parseInt(userid));
		orderstService.saveOrders(orders);// 产品新增
		response.sendRedirect("ordersServletList");// 新增成功后跳转到产品列表页
	}

}
