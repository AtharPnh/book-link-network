package com.athar.book;

import com.athar.book.role.Role;
import com.athar.book.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BookLinkApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookLinkApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if(roleRepository.findByName("User").isEmpty()) {
				roleRepository.save(
						Role.builder().name("User").build()
				);
			}
		};
	}
}
