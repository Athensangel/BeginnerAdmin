package service.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;
/**
 *ProductService实现的接口，为Dao层提供接口
 * @author Administrator
 *
 */
public class ProductServiceImpl implements ProductService {
	public ProductDao productDao =new ProductDaoImpl(); 
	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/**
	 * 查询产品信息
	 */
	@Override
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}
	/**
	 * 添加产品信息
	 */
	@Override
	public void saveProduct(Product product) {
		productDao.InsertProduct(product);
	}
	/**
	 *删除产品信息
	 */
	@Override
	public void deletProductById(Integer toid) {
		productDao.delProductById(toid);
	}
	/**
	 * 通过ID来查询产品信息
	 */
	@Override
	public Product queryProductById(Integer toid) {
		return productDao.findProductById(toid);
	}
	/**
	 * 修改产品信息
	 */
	@Override
	public void updateProductById(Product product) {
		productDao.updateProductById(product);
	}
	/**
	 * 添加产品信息
	 */
	@Override
	public void updateProductInfo(Product product) {
		productDao.updateProductInfo(product);
	}

}
