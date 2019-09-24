package zh.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import zh.dao.UserDao;
import zh.pojo.User;
import zh.utils.SqlSessionFactoryUtil;
 
public class UserDaoImpl implements UserDao{

	
	@Override
	public User getUserById(Integer id) {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		User user=openSession.selectOne("getUserById",id);
		openSession.close();
		return user;
	}
	
	@Override

	public List<User> getUserByName(String name) {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		List<User> list=openSession.selectList("getUserByName",name);
		openSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSessionFactory sessionFactory = SqlSessionFactoryUtil.getSessionFactory();
		SqlSession openSession = sessionFactory.openSession(true);
		openSession.insert("insertUser",user);
		openSession.close();
	}

}
