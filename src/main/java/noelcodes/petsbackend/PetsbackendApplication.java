package noelcodes.petsbackend;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PetsbackendApplication {
	private static final Logger log = LoggerFactory.getLogger(PetsbackendApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(PetsbackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(PetRepository petRepo) {
		return (args) -> {
			log.info("Adding 2 pets to pets table");

			petRepo.save(new Pet("Demon", "Pitbull",
					LocalDate.of(2020, 10, 15), "black"));

			petRepo.save(new Pet("Daisy", "Poddle",
					LocalDate.of(2015, 1, 1), "white"));

			log.info("Added 2 pets to pets table.");

			log.info("Fetching all pets");
			for(Pet pet : petRepo.findAll()){
				System.out.println(pet.toString());
			}
		};
	}
}
