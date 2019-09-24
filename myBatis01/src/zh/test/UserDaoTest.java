package zh.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import zh.dao.UserDao;
import zh.dao.impl.UserDaoImpl;
import zh.mapper.UserMapper;
import zh.pojo.User;
import zh.utils.SqlSessionFactoryUtil;

public class UserDaoTest {
	@Test
	public void testGetUserById() {
		UserDao userDao=new UserDaoImpl();
		User user = userDao.getUserById(1);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		UserDao userDao=new UserDaoImpl();
		List<User> list = userDao.getUserByName("为情");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInsertUser() {
		UserDao userDao=new UserDaoImpl();
		User user = new User();
		user.setUsername("nihao");
		user.setAddress("天津");
		user.setBirthday(new Date());
		user.setSex("2");
		userDao.insertUser(user);
	}

}
