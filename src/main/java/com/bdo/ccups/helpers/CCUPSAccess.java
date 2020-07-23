package com.bdo.ccups.helpers;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public  final class CCUPSAccess {

    public Boolean CheckRole(String role){

        Boolean result=false;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         if (principal instanceof UserDetails) {
            result = ((UserDetails)principal).getAuthorities().contains(new SimpleGrantedAuthority(role));

         } 



        return result;
    }
    
}