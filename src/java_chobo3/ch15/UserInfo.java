package java_chobo3.ch15;

public class UserInfo {
	private String name;
	private String password;
	private int age;

	public UserInfo() {
		this("Unknown", "1111", 0);
	}

	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("UserInfo [%s %s %s]", name, password, age);
	}

}
