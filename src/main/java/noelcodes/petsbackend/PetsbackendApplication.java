package noelcodes.petsbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class PetsbackendApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(PetsbackendApplication.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PetsbackendApplication.class, args);
	}

	@Override
	public void run(String... strings) {
		log.info("Creating pets and owners table");

		jdbcTemplate.execute("DROP TABLE IF EXISTS pets");
		jdbcTemplate.execute("DROP TABLE IF EXISTS owners");

		// Many-to-one relationship in which an OWNER can have many PETS.
		String createOwnersTableQuery = "CREATE TABLE owners(" +
				"owner_Id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL," +
				"firstName VARCHAR(255) NOT NULL, " +
				"lastName VARCHAR(255) NOT NULL, " +
				"dob DATE NOT NULL," +
				"address VARCHAR(255) NOT NULL)";

		// Foreign key owner_id on pet table to reference who the owner is.
		String createPetTableQuery = "CREATE TABLE pets(" +
				"pet_Id INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL," +
				"name VARCHAR(255) NOT NULL, " +
				"breed VARCHAR(255) NOT NULL, " +
				"dob DATE NOT NULL," +
				"furColor VARCHAR(255) NOT NULL, " +
				"owner_Id INT NOT NULL, " +
				"FOREIGN KEY (owner_Id) REFERENCES owners(owner_Id) " +
				"ON DELETE CASCADE ON UPDATE CASCADE)";

		jdbcTemplate.execute(createOwnersTableQuery);
		jdbcTemplate.execute(createPetTableQuery);

		log.info("Pets and Owners tables created");
	}

}
