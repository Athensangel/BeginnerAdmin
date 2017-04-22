package dao;

import java.util.List;

import model.Orders;
/**
 * OrdersDao实现类
 * @author Administrator
 *
 */

public interface OrdersDao {

	public List<Orders> queryAllOrders();//查询Orders的字段信息

	public void insertOrders(Orders orders);//插入一行语句给Orders

	public void delOrdersById(Integer toid);//删除一行语句给Orders

	public Orders findOrdersById(Integer toid);

	public void updateOrdersById(Orders orders);//修改一条记录

	public void updateOrdersInfo(Orders orders);

}
