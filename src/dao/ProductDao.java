package dao;

import java.util.List;

import model.Product;

/**
 * ProductDao的接口
 * @author Administrator
 *
 */
public interface ProductDao {

	public List<Product> findAllProduct();

	public void InsertProduct(Product product);

	public void delProductById(Integer toid);

	public Product findProductById(Integer toid);

	public void updateProductById(Product product);

	public void updateProductInfo(Product product);

}
