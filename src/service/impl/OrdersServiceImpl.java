package service.impl;

import java.util.List;

import dao.OrdersDao;
import dao.impl.OrdersDaoImpl;
import model.Orders;
import service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	
	OrdersDao ordersDao=new OrdersDaoImpl();
	
	
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public List<Orders> findAllOrders() {
		// TODO Auto-generated method stub
		return ordersDao.queryAllOrders();
	}

	@Override
	public void saveOrders(Orders orders) {
		ordersDao.insertOrders(orders);
	}

	@Override
	public void deletOrdersById(Integer toid) {
		ordersDao.delOrdersById(toid);
	}

	@Override
	public Orders queryOrdersById(Integer toid) {
		return ordersDao.findOrdersById(toid);
	}

	@Override
	public void updateOrdersById(Orders orders) {
		ordersDao.updateOrdersById(orders);
	}

	@Override
	public void updateOrdersInfo(Orders orders) {
		ordersDao.updateOrdersInfo(orders);
	}

}
