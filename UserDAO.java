package users;

public interface UserDAO {
	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(String userid);
	public User getUser(String userid);
}
