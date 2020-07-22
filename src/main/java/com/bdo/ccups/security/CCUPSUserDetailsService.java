package com.bdo.ccups.security;

import java.util.ArrayList;
import java.util.List;

import com.bdo.ccups.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CCUPSUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub

        com.bdo.ccups.model.User logedInUser=userRepo.findByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        // authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        // authorities.add(new SimpleGrantedAuthority("ROLE_APPROVER"));
        if(logedInUser!=null){
            logedInUser.getRoles().forEach(item->{
                authorities.add(new SimpleGrantedAuthority(item.getName()));

            });
            return new User(logedInUser.getUserName(), "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
            authorities);
        } else {
            	throw new UsernameNotFoundException("User not found with username: " + username);
            }
       
    }

    public void SaveToken(String token,String userName){
        com.bdo.ccups.model.User logedInUser=userRepo.findByUserName(userName);
        logedInUser.setToken(token);
        userRepo.save(logedInUser);


    }

    public Boolean CheckToken(String token,String userName){
        com.bdo.ccups.model.User logedInUser=userRepo.findByUserName(userName);
        return logedInUser.getToken().equals(token);
        


    }

    public void Logout(String userName){
        com.bdo.ccups.model.User logedInUser=userRepo.findByUserName(userName);
        logedInUser.setToken("");
        userRepo.save(logedInUser);


    }

}