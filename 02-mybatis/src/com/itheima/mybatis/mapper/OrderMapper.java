package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.Order;
import com.itheima.mybatis.pojo.OrderUser;

/**
 * 订单持久化接口
 * @author Steven
 *
 */
public interface OrderMapper {

	/**
	 * 获取订单列表
	 * @return
	 */
	List<Order> getOrderList();
	
	/**
	 * ResultMap使用
	 * @return
	 */
	List<Order> getOrderListMap();
	
	/**
	 * 一对一关联：resultType使用
	 * @return
	 */
	List<OrderUser> getOrderUser();
	
	/**
	 * 一对一关联：ReaultMap使用
	 * @return
	 */
	List<Order> getOrderUserMap();
}
