package spring.test;

import java.util.List;

public interface UserDao {
	public List<UserModel> getUser(String id);
}
