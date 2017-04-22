package model;
/**
 * Product的实体类
 * @author Administrator
 *
 */
public class Product {
	public Integer toId;		//主键通过Integer来接收
	
	public String productName;  //主键通过String来接收
	
	public Float price;		    //主键通过Float来接收

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
