package noelcodes.petsbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsbackendApplication {
	private static final Logger log = LoggerFactory.getLogger(PetsbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetsbackendApplication.class, args);
	}
}
