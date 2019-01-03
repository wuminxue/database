package users;

public class User {
	private String userid;
	private String username;
	private String password;
	private String domainname;
	private String email;
	private String phonenumber;
	private String address;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		if(userid == null) {
			System.out.println("账号不能为空");
		}
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username == null) {
			System.out.println("昵称不能为空");
		}
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password == null) {
			System.out.println("密码不能为空");
		}
		this.password = password;
	}
	public String getDomainname() {
		return domainname;
	}
	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
