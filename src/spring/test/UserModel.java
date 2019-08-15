package spring.test;

public class UserModel {
	String user_id;
	String user_name;
	

	public String getId() {
		return user_id;
	}

	public void setId(String id) {
		this.user_id = id;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
	}
}

