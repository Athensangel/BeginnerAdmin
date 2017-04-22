package model;

public class Message {
	public Integer id;
	
	public Integer fromId;
	
	public Integer toId;
	
	public String content;
	
	public String isRead;
	public String realNameFrom;
	public String realNameTo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getRealNameFrom() {
		return realNameFrom;
	}

	public void setRealNameFrom(String realNameFrom) {
		this.realNameFrom = realNameFrom;
	}

	public String getRealNameTo() {
		return realNameTo;
	}

	public void setRealNameTo(String realNameTo) {
		this.realNameTo = realNameTo;
	}
}
