package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.services;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthenticationService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return service.getUserByEmail(username).map(UserAuth::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
