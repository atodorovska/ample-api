package mk.ukim.finki.ampleapi;

import mk.ukim.finki.ampleapi.config.StorageConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfiguration.class)
@EnableScheduling
public class AmpleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmpleApiApplication.class, args);
	}
}
