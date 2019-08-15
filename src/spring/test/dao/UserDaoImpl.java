package spring.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.test.UserDao;
import spring.test.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserModel> getUser(String eMail, String password) {
		List<UserModel> list = jdbcTemplate.query("select * from t_user where user_email= ? and user_password = ?", new Object[] { eMail,password },
				new RowMapper<UserModel>() {
					public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserModel user = new UserModel();
						user.setId(rs.getString("user_id"));
						user.setName(rs.getString("user_name"));
						return user;
					}
				});
		return list;
	}

}