package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3;


import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.Role;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.User;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.RoleRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
@Slf4j
public class MusicAdjafMf3Application {

	public static void main(String[] args) {
		SpringApplication.run(MusicAdjafMf3Application.class, args);
	}

	@Bean
	ApplicationRunner runner (RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			var roles = Set.of(
					new Role(null,"ADMIN"),
					new Role(null,"REGENTE"),
					new Role(null,"SONOPLATA"),
					new Role(null,"USER")
			);
			try {
				roleRepository.saveAll(roles);
			} catch (Exception e) {
                log.info("Roles ja cadastradas");
            }
//			User user = new User("koymattk@gmail.com", encoder.encode("123321"), "79988088092", null);
//			user.setRoles(Set.of(roleRepository.findById(4).get(),roleRepository.findById(3).get()));
//			userRepository.save(user);
        };
	}
}
