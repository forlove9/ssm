package com.itheima.mybatis.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.ssm.mapper.UserMapper;
import com.itheima.ssm.po.User;
import com.itheima.ssm.po.UserExample;
import com.itheima.ssm.po.UserExample.Criteria;

public class UserMapperGTest {
	
	private ApplicationContext applicationContext;

	@Before
	public void init() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testInsertSelective() {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		User user = new User();
		user.setUsername("诸葛亮");
		user.setAddress("深圳黑马");
		user.setSex("1");
		userMapper.insertSelective(user);
	}

	@Test
	public void testSelectByExample() {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		UserExample example = new UserExample();
		//创建Criteria
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andUsernameLike("%张%");
		criteria.andSexEqualTo("2");
		List<User> list = userMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testSelectByPrimaryKey() {
		UserMapper userMapper = applicationContext.getBean(UserMapper.class);
		
		User user = userMapper.selectByPrimaryKey(30);
		System.out.println(user);
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

}
