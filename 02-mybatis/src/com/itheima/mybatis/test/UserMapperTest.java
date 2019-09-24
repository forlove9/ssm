package com.itheima.mybatis.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.Order;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.utils.SqlSessionFactoryUtils;

public class UserMapperTest {

	@Test
	public void testGetUserById() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.getUserById(30);
		
		System.out.println(user);
		
		sqlSession.close();
	}

	@Test
	public void testGetUserByUserName() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.getUserByUserName("张");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("赵子龙");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("深圳黑马");
		
		userMapper.insertUser(user);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	@Test
	public void testGetUserByQueryVo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user2 = new User();
		user2.setUsername("张");
		
		vo.setUser(user2);
		
		List<User> list = userMapper.getUserByQueryVo(vo);
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetUserCount() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Integer userCount = userMapper.getUserCount();
		System.out.println("用户总记录数为：" + userCount);
		sqlSession.close();
	}
	
	@Test
	public void testGetUserByPojo() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张");
		List<User> list = userMapper.getUserByPojo(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetUserByIds() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		//构建id列表
		vo.setIds(Arrays.asList(1,25,29,30,35));
		List<User> list = userMapper.getUserByIds(vo);
		for (User user2 : list) {
			System.out.println(user2);
		}
		sqlSession.close();
	}
	
	@Test
	public void testGetUserOrderMap() {
		SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
		//获取接口的代理人实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.getUserOrderMap();
		for (User user2 : list) {
			System.out.println(user2);
			for (Order order : user2.getOrders()) {
				if(order.getId() != null){
					System.out.println("      此用户下的订单有：" + order);
				}
			}
		}
		sqlSession.close();
	}

}
