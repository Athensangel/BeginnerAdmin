package service;

import java.util.List;

import model.Product;
/**
 * 定义Product接口的增删改查方法
 * @author Administrator
 *
 */
public interface ProductService {

	public List<Product> findAllProduct();//遍历查询orders表中的字段

	public void saveProduct(Product product);//新增订单

	public void deletProductById(Integer toid);//通过toId查找订单信息并做删除处理

	public Product queryProductById(Integer toid);//通过toId查找订单信息并做删除处理

	public void updateProductById(Product product);//查找订单，并修改订单信息

	public void updateProductInfo(Product product);// 更改订单信息

}
