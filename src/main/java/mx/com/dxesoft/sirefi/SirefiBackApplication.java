package mx.com.dxesoft.sirefi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "mx.com.dxesoft.sirefi.repository")
@EntityScan(basePackages = "mx.com.dxesoft.sirefi.entity")
@Configuration
public class SirefiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SirefiBackApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
