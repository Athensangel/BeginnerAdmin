package service;

import java.util.List;

import model.Orders;

public interface OrdersService {

	public List<Orders> findAllOrders();//遍历查询Orders表中的字段

	public void saveOrders(Orders orders);//新增产品

	public void deletOrdersById(Integer toid);//通过toId查找产品信息并做删除处理

	public Orders queryOrdersById(Integer toid);//通过toId查找产品信息并做删除处理

	public void updateOrdersById(Orders orders);//查找产品，并修改产品信息

	public void updateOrdersInfo(Orders orders);// 更改产品信息
}
