package users;
import java.io.IOException;
import java.util.*;

public class Test {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String userid = null;
		User user = new User();
		UserOperation op = new UserOperation();
		String button = "1";
		while(button != "0"){
			System.out.println("请选择用户操作:'1'添加新的用户数据;'2'更新用户数据;'3'注销用户;'4'查询用户信息;'0'退出操作");
			String select = sc.nextLine();
			switch(select) {
			case"1":op.insertUser(user);break;
			case"2":op.updateUser(user);break;
			case"3":op.deleteUser(userid);break;
			case"4":op.getUser(userid);break;
			case"0":button = "0";break;
			default:System.out.println("请输入正确的操作符");
			}
		}
		System.out.println("系统提示:退出操作");
	}
}
