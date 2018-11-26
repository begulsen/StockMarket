package controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import model.User;
import services.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private IUserService userServiceInterface;

	public IUserService getUserServiceInterface() {
		return userServiceInterface;
	}

	public void setUserServiceInterface(IUserService userServiceInterface) {
		this.userServiceInterface = userServiceInterface;
	}
	
	@ApiOperation(value = "Edit User")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user){
        User userModel = userServiceInterface.findUserById(user.getId());
        userModel.setId(user.getId());
        userModel.setLogin(user.getLogin());
        userModel.setProfile(user.getProfile());
        userModel.setUserMail(user.getUserMail());
        userModel.setCreateDate(user.getCreateDate());
        
        userServiceInterface.saveUser(user);
        return new ResponseEntity("User updated", HttpStatus.OK);
    }
	
	@ApiOperation(value = "Delete user")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable int id){
        userServiceInterface.deleteUser(id);;
        return new ResponseEntity("User deleted", HttpStatus.OK);

    }
}
