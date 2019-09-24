package com.itheima.mybatis.pojo;

import java.util.Date;

/**
 * 订单关联用户的pojo
 * @author Steven
 *
 */
public class OrderUser extends Order {
	
	private String username;// 用户姓名
	private String address;// 地址
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrderUser [username=" + username + ", address=" + address + ", getId()=" + getId() + ", getUserId()="
				+ getUserId() + ", getNumber()=" + getNumber() + ", getCreatetime()=" + getCreatetime() + ", getNote()="
				+ getNote() + "]";
	}
	
}
