package com.maurya.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users =new ArrayList<User>();
	
	private static int userCount=0;
	
	static {
		users.add(new User(++userCount,"Sarvesh",LocalDate.now().minusYears(24)));
		users.add(new User(++userCount,"Ramesh",LocalDate.now().minusYears(34)));
		users.add(new User(++userCount,"Sanjay",LocalDate.now().minusYears(4)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		//Predicate < ? super User> predicate =user -> user.getId().equals(id)
//		Predicate<? super User> predicate =user -> user.getId().equals(id);
//		return users.stream().filter(predicate ).findFirst().orElse(null);
		
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
		
	}
	
	public void deleteById(int id) {
		//Predicate < ? super User> predicate =user -> user.getId().equals(id)
		Predicate<? super User> predicate =user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
		
}
