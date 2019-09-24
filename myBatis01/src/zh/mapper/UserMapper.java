package zh.mapper;

import java.util.List;

import zh.pojo.User;

public interface UserMapper {
	User getUserById(Integer id);
	List<User> getUserByName(String name);
	void insertUser (User user);
}
