package users;
import java.io.*;
import java.util.*;
import java.sql.*;
import users.User;

public class UserOperation extends DAOBase implements UserDAO {
	public static void input(User user) throws IOException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户信息:");
		System.out.println("账号:");
		user.setUserid(sc.nextLine());
		System.out.println("设置昵称:");
		user.setUsername(sc.nextLine());
		System.out.println("设置密码:");
		user.setPassword(sc.nextLine());
		System.out.println("设置域名:");
		user.setDomainname(sc.nextLine());
		System.out.println("设置邮箱地址:");
		user.setEmail(sc.nextLine());
		System.out.println("设置手机号:");
		user.setPhonenumber(sc.nextLine());
		System.out.println("所在地:");
		user.setAddress(sc.nextLine());
	}
	private static final String CREATE_USER_SQL = "INSERT INTO Customer (userid, username, password, domainname, email, phonenumber, address) VALUES (?,?,?,?,?,?,?)";
	public void insertUser(User user) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			input(user);
			pst = conn.prepareStatement(CREATE_USER_SQL);
			pst.setString(1,user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3,user.getPassword());
			pst.setString(4,user.getDomainname());
			pst.setString(5, user.getEmail());
			pst.setString(6, user.getPhonenumber());
			pst.setString(7,user.getAddress());
			int row = pst.executeUpdate();
			System.out.println("成功更新了"+row+"个用户数据");
			pst.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null) {
				try {
					pst.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void updateUser(User user) {
		try {
			Connection conn = null;
			Statement stmt = null;
			@SuppressWarnings("unused")
			int rs;
			try {
				conn = getConnection();
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("请输入账号以修改信息:");
				String userid = sc.nextLine();
				stmt = conn.createStatement();
				String sql = "delete from Customer where userid="+userid;
				rs = stmt.executeUpdate(sql+sc.nextLine());
				insertUser(user);
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if(stmt!=null) {
					try {
						stmt.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(String userid) {
		Connection conn = null;
		Statement stmt = null;
		int rs;
		try {
			conn = getConnection();
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入需要注销的账号:");
			userid = sc.nextLine();
			stmt = conn.createStatement();
			String sql = "delete from Customer where userid=";
			rs = stmt.executeUpdate(sql+userid);
			System.out.println("第"+rs+"个账号已被注销");
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static final String SEARCH_USER = "SELECT userid,username,password,domainname,email,phonenumber,address FROM Customer WHERE userid=";
	public User getUser(String userid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		try{
			conn = getConnection();
			stmt = conn.createStatement();			
			@SuppressWarnings("resource")
			Scanner ReadStr=new Scanner(System.in);
			System.out.println("请输入要查询的用户账号:");		 
			userid=ReadStr.nextLine();
			String endsql = null;
			endsql = SEARCH_USER +userid;
			rs=stmt.executeQuery(endsql);
			while(rs.next()){				
				user.setUserid(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setDomainname(rs.getString("domainname"));
				user.setEmail(rs.getString("email"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setAddress(rs.getString("address"));
				System.out.println("账号:"+user.getUserid()+"\t昵称"+user.getUsername()+"\n密码:"+user.getPassword()+"\t域名:"+user.getDomainname()+"\n邮箱:"+user.getEmail()+"\t手机:"+user.getPhonenumber()+"\n所在地:"+user.getAddress());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}
