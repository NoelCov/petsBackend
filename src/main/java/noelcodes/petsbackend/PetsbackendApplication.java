package noelcodes.petsbackend;

import jakarta.transaction.Transactional;
import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Models.Role;
import noelcodes.petsbackend.Repositories.PetOwnerRepository;
import noelcodes.petsbackend.Repositories.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PetsbackendApplication {
	private static final Logger log = LoggerFactory.getLogger(PetsbackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PetsbackendApplication.class, args);
	}

	@Transactional
	@Bean
	public CommandLineRunner run(PetRepository petRepository, PetOwnerRepository petOwnerRepository) {
		return (args) -> {
			Pet pet1 = new Pet("Demon", "Pitbull",
					LocalDate.of(2020, 10, 15), "black");

			Pet pet2 = new Pet("Daisy", "Poddle",
					LocalDate.of(2015, 1, 1), "white");

			PetOwner petOwner1 = new PetOwner(
					"Noel",
					"Covarrubias",
					LocalDate.of(1996, 9, 27),
					"451 N. Maple Avenue",
					"noel@email.com",
					"1234566",
					Role.USER);

			PetOwner petOwner2 = new PetOwner(
					"Aron",
					"Mercado",
					LocalDate.of(1996, 9, 27),
					"451 N. Maple Avenue",
					"aron@email.com",
					"123456",
					Role.USER);

			// remember that you don't have to add the pet to the pets list in the owner entity.
			// It's done automatically I guess because of the foreign key.
			//	petOwner2.setPets(List.of(pet2));

			log.info("Adding 2 pet owners to petOwners table");
			petOwnerRepository.saveAll(List.of(petOwner1, petOwner2));
			log.info("Added 2 petOwners to petOwners table");


			pet1.setOwner(petOwner1);
			pet2.setOwner(petOwner2);

			log.info("Adding 2 pet owners to petOwners table");
			petOwnerRepository.saveAll(List.of(petOwner1, petOwner2));
			log.info("Added 2 petOwners to petOwners table");

			log.info("\nAdding 2 pets to pets table");
			petRepository.saveAll(List.of(pet1, pet2));
			log.info("Added 2 pets to pets table.");
		};
	}
}
