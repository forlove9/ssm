package zh.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import zh.mapper.UserMapper;
import zh.pojo.User;
import zh.utils.SqlSessionFactoryUtil;

public class UserMapperTest {

	@Test
	public void testGetUserById() {
		SqlSession openSession = SqlSessionFactoryUtil.getSessionFactory().openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);
	}

	@Test
	public void testGetUserByName() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSessionFactory().openSession();
	     // 获取代理对象
	     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	     // 查询数据
	     List<User> list = userMapper.getUserByName("张");
	     for (User user : list) {
	         System.out.println(user);
	     }
	     // 关闭资源
	     sqlSession.close();
	}

	@Test
	public void testInsertUser() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSessionFactory().openSession();
	     UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
	     User user = new User();
	     user.setUsername("张飞飞");
	     user.setAddress("深圳市黑马");
	     user.setBirthday(new Date());
	     user.setSex("1");
	     userMapper.insertUser(user);
	     // 提交事务
	     sqlSession.commit();
	     // 关闭资源
	     sqlSession.close();
	}

}
