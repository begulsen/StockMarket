package services;

import model.User;

public interface IUserService {
	Iterable<User> listAllUser();
	
	User saveUser(User share);
	
	User findUserById(Integer id);
	
	void deleteUser(Integer id);
	
	
}
