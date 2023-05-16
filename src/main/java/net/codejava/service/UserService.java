package net.codejava.service;

import net.codejava.Interface.Provider;
import net.codejava.model.Oauth;
import net.codejava.repository.OauthRepo;
import net.codejava.repository.UserRepository;
import net.codejava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private OauthRepo oauthRepo;
	@Autowired
	private UserRepository repo;
	
	public void processOAuthPostLogin(String username) {
		User existUser = repo.getUserByUsername(username);
		
		if (existUser == null) {
			Oauth oauth=new Oauth(username);
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setProvider(Provider.GOOGLE);
			newUser.setEnabled(true);			
			
			repo.save(newUser);
			
			System.out.println("Created new user: " + username);

			oauthRepo.save(oauth);
		}
		
	}
	
}
