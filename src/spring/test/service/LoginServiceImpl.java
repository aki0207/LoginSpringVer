package spring.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.test.LoginService;
import spring.test.UserDao;
import spring.test.UserModel;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean checkLogin(UserModel lm) {
		List<UserModel> list = userDao.getUser(lm.geteMail(),lm.getPassword());
		return list.size() > 0;
	}
}

			