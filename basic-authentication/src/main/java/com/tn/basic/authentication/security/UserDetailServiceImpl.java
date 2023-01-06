package com.tn.basic.authentication.security;

import com.tn.basic.authentication.orm.UserEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity("TN","$2a$12$6/p7ieFDZWdh5Ck80mofwuShQ2YCb4UoJkI/87lDlHZS8FEkpJJRe");
        List<SimpleGrantedAuthority> listAuthorities = new ArrayList<>();
        listAuthorities.add(new SimpleGrantedAuthority("ROLE_PARTNER"));
        listAuthorities.add(new SimpleGrantedAuthority("ROLE_SUB_PARTNER"));
        return new User(userEntity.getUsername(),userEntity.getPassword(),listAuthorities);
    }
}
