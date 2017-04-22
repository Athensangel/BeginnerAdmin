package com.oa.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UserServletSave
 */

/**
 * 添加员工信息
 * 
 * @author Administrator
 *
 */
@WebServlet("/productServletSave")
public class ProductServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductServiceImpl();

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServletSave() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("views/product/productSave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productname = request.getParameter("productName");
		String price = request.getParameter("price");
		Product product = new Product();
		product.setProductName(productname);
		product.setPrice(Float.parseFloat(price));
		productService.saveProduct(product); // 产品新增
		response.sendRedirect("productServletList");// 新增成功后跳转到产品列表页
	}

}
