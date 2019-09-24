package com.itheima.mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper;
import com.itheima.mybatis.pojo.Order;
import com.itheima.mybatis.pojo.OrderUser;
import com.itheima.mybatis.utils.SqlSessionFactoryUtils;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class OrderMapperTest {

	@Test
	public void testGetOrderList() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取OrderMapper代理实现
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper.getOrderList();
		for (Order order : list) {
			System.out.println(order);
		}
		
		sqlSession.close();
	}
	
	@Test
	public void testGetOrderListMap() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取OrderMapper代理实现
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper.getOrderListMap();
		for (Order order : list) {
			System.out.println(order);
		}
		
		sqlSession.close();
	}
	
	@Test
	public void testGetOrderUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取OrderMapper代理实现
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<OrderUser> list = orderMapper.getOrderUser();
		for (OrderUser orderUser : list) {
			System.out.println(orderUser);
		}
		
		sqlSession.close();
	}
	
	@Test
	public void testGetOrderUserMap() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取OrderMapper代理实现
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		
		List<Order> list = orderMapper.getOrderUserMap();
		for (Order order : list) {
			System.out.println(order);
			System.out.println("      此订单的用户为：" + order.getUser());
		}
		
		sqlSession.close();
	}

}
