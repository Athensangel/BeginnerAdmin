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
 * Servlet implementation class UserServletUpdate
 */
/**
 * 订单的修改
 * @author Administrator
 *
 */
@WebServlet("/ordersServletUpdate")
public class OrdersServletUpdate extends HttpServlet {
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
	public OrdersServletUpdate() {
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
		Orders orders = orderstService.queryOrdersById(Integer.parseInt(toid));
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/views/orders/ordersUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String toid = request.getParameter("toid");
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
		orders.setToid(Integer.parseInt(toid));
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
		orderstService.updateOrdersById(orders);// 订单修改
		response.sendRedirect("ordersServletList"); // 修改成功后跳转到订单列表页
	}

}
