package tr.com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class InMemoryCacheApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryCacheApiApplication.class, args);
	}

}