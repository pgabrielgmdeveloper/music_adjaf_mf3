package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.services;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.Role;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.User;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.RoleRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final ApplicationContext context;
    private final JWTService tokenService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public void createUser(User user) {
        passwordEncoder = context.getBean(PasswordEncoder.class);
        var role = roleRepository.findById(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(role.get()));
        repository.save(user);
    }

    public Optional<User> getUserByEmail(String username) {
        return repository.findById(username);
    }

    public AuthResponse login(AuthRequest data){
        authenticationManager = context.getBean(AuthenticationManager.class);
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var authorities = auth.getAuthorities();
        var token = tokenService.generateToken(auth);
        return new AuthResponse(token, authorities.stream().map(role -> role.getAuthority()).toList());
    }

}
