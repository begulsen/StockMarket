package services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import model.User;
import repositories.UserRepo;

@Service
public class UserService implements IUserService{
	
	private UserRepo userRepo;

	@Override
	public Iterable<User> listAllUser() {
		Iterable<User> userList= userRepo.findAll();
		return userList;
	}

	@Override
	public User saveUser(User user) {
		userRepo.save(user);
		return null;
	}

	@Override
	public User findUserById(Integer id) {
		Optional<User> userOpt = userRepo.findById(id);
		User user = userOpt.orElseThrow(RuntimeException::new);
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
		
	}

	public UserRepo getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

}
