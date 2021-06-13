package com.application.project3.security;

import com.application.project3.entities.UserMain;
import com.application.project3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsRepository implements UserDetailsService {

    private final UserRepository userRepo;

    @Autowired
    public UserDetailsRepository(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
       UserMain userMain = userRepo.findByUserId(userId);
       if(userMain != null){
           return userMain;
       }else{
           throw new UsernameNotFoundException("User not found: " + userId);
       }
    }


}
