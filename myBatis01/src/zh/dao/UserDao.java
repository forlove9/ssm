package zh.dao;

import java.util.List;

import zh.pojo.User;

public interface UserDao {
	User getUserById(Integer id);
	List<User> getUserByName(String name);
	void insertUser (User user);
	
}
