package com.example.departmentmanagementproject.Service.ServiceImp;


import com.example.departmentmanagementproject.Model.User;
import com.example.departmentmanagementproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User appUser = this.userRepository.findUserByUserName(username);
        if(appUser == null) {
            System.out.println("User not found! "+username);
            throw new UsernameNotFoundException("User " + username + " was not found in database");
        }
        else {
            System.out.println("User found! "+username);
            System.out.println("Password: " + appUser.getPassword());
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        return new org.springframework.security.core.userdetails.User(
                appUser.getUserName(),
                appUser.getPassword(),
                authorities);
    }
}
