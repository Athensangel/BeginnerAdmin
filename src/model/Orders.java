package model;

public class Orders {
	private Integer toid;  			//主键，自动增长
	private String custName;		//客户姓名
	private String custAddress;		//客户地址
	private String custPhone;		//客户电话
	private String custEmail;		//客户邮箱
	private String oderTime;		//订购时间
	private Integer productId;  	//订购的产品，来自产品表
	private Integer productCount;  	//订购数目
	private Float   money;			//所付金额
	private String createTime;		//订单新增时间
	private Integer userId;  		//所属销售员工，来自员工表
	public String userRealName;
	public Integer getToid() {
		return toid;
	}
	public void setToid(Integer toid) {
		this.toid = toid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getOderTime() {
		return oderTime;
	}
	public void setOderTime(String oderTime) {
		this.oderTime = oderTime;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
}
