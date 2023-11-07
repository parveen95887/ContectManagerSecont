package com.smart.contact.helper;

public class massage {

	String type;
	String content;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public massage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public massage(String type, String content) {
		super();
		this.type = type;
		this.content = content;
	}
}
