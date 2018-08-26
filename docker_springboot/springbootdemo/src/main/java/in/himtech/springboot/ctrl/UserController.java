package in.himtech.springboot.ctrl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.himtech.springboot.domain.User;

@RestController
@RequestMapping("/usrmgmt")
public class UserController {
	private Map<String, User> dbUsers;
	private static int count = 0;

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		if (user.getUserId() == null) {
			count++;
			user.setUserId(String.valueOf(count));
			dbUsers.put(String.valueOf(count), user);
			return String.valueOf(count);
		} else {
			return "user already exist";
		}
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String userId) {
		if (dbUsers.keySet().contains(userId)) {
			dbUsers.remove(userId);
			return "user successfully deleted";
		} else {
			return "No such user exist";
		}
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		if (dbUsers.keySet().contains(userId)) {
			User user = dbUsers.get(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUser = new ArrayList<>(dbUsers.values());
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	@PostConstruct
	public void initialization(){
		dbUsers = new HashMap<String, User>(); 
		Collections.synchronizedMap(dbUsers);
	}

}
