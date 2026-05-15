package com.practice.db.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.db.security.model.User;
import com.practice.db.security.repo.UserRepo;

@Service
public class UserService implements IUserService,UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public Integer saveUser(User user) throws Exception {
		String pwd=user.getUserPwd();
		pwd=pwdEncoder.encode(pwd);
		user.setUserPwd(pwd);
		User saveUser=null;
		if(user!=null && user.getUserEmail().length()!=0) {
			
			saveUser = userRepo.save(user);
		}else {
			throw new Exception("files must not be null");
		}
		return saveUser.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User suser = userRepo.findByUserEmail(username);

		// map to security user
		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
				suser.getUserEmail(), 
				suser.getUserPwd(), 
				//suser.getRole().stream().map(role -> new SimpleGrantedAuthority(role)).toList()
				suser.getRole().stream().map(SimpleGrantedAuthority::new).toList()
				);
		return user;
	}

}
