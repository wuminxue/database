package users;
import java.sql.*;

public class DAOBase implements DAO{
	Connection conn;
	public Connection getConnection() {
		try {
			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			Class.forName(driverName);
			System.out.println("数据库驱动加载成功");
		}catch (Exception e) {
			System.out.println("无法找到驱动类");
			e.printStackTrace();
		}
		try {
			String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=Recommended_System";
			String userName = "sa";
			String password = "Ge62214388";
			conn = DriverManager.getConnection(dbURL, userName, password);
			System.out.println("数据库连接成功");
		}catch(Exception e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return conn;
	}
}