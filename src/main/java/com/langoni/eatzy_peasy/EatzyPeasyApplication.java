package com.langoni.eatzy_peasy;

import com.langoni.eatzy_peasy.domain.repository.CustomJpaRepository;
import com.langoni.eatzy_peasy.infra.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class EatzyPeasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EatzyPeasyApplication.class, args);
	}

}
