package com.itheima.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User getUserById(Integer id) {
		SqlSession sqlSession= super.getSqlSession();
		User user = sqlSession.selectOne("user.getUserById", id);
		//这里不能关闭SqlSession
		//sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByUserName(String userName) {
		SqlSession sqlSession= super.getSqlSession();
		List<User> list = sqlSession.selectList("user.getUserByUserName", userName);
		return list;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession= super.getSqlSession();
		sqlSession.insert("user.insertUser", user);
	}

}
