package zh.test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import zh.pojo.User;
import zh.utils.SqlSessionFactoryUtil;

public class MybatisTest {
	@Test
	public void testGetUserById() throws Exception {
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		//创建核心配置文件输入流
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//通过输入流创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sfb.build(in);
		//创建SqlSession对象
		SqlSession session = sqlSessionFactory.openSession();
		//执行查询， 参数一：【命名空间】.sql id   参数二：查询的入参
		User user = session.selectOne("user.getUserById", 1);
		System.out.println(user.toString());
		session.close();
	}
	
	@Test
	public void testGetUserByName() throws Exception {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		List<User> list = openSession.selectList("user.getUserByName","张");
		for (User user : list) {
			System.out.println(user);
		}
		openSession.close();
	}
	
	@Test
	public void testInsertUser() throws Exception {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setUsername("张飞");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("深圳");
		openSession.insert("insertUser", user);
		System.out.println(user);
		openSession.commit();
		openSession.close();
	}
	
	
	@Test
	public void testUpdateUser() throws Exception {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		User user = new User();
		user.setId(25);
		user.setUsername("为情2");
		openSession.update("updateUser", user);
		System.out.println(user);
		openSession.commit();
		openSession.close();
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		openSession.delete("deleteUser",31);
		openSession.commit();
		openSession.close();
	}
}
