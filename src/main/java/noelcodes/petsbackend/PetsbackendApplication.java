package noelcodes.petsbackend;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import noelcodes.petsbackend.Repositories.PetOwnerRepository;
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
	public CommandLineRunner run(PetRepository petRepository, PetOwnerRepository petOwnerRepository) {
		return (args) -> {
			log.info("Adding 2 pets to pets table");

			petRepository.save(new Pet("Demon", "Pitbull",
					LocalDate.of(2020, 10, 15), "black"));

			petRepository.save(new Pet("Daisy", "Poddle",
					LocalDate.of(2015, 1, 1), "white"));

			log.info("Added 2 pets to pets table.");

			log.info("Adding 2 pet owners to petOwners table");

			petOwnerRepository.save(new PetOwner("Noel", "Covarrubias",
					LocalDate.of(1996, 9, 27), "451 N. Maple Avenue"));

			petOwnerRepository.save(new PetOwner("Aron", "Mercado",
					LocalDate.of(1996, 9, 27), "451 N. Maple Avenue"));

			log.info("Added 2 petOwners to petOwners table");

			log.info("Fetching all pets");
			for(Pet pet : petRepository.findAll()){
				System.out.println(pet.toString());
			}

			log.info("Fetching all petOwners");
			for(PetOwner petOwner : petOwnerRepository.findAll()){
				System.out.println(petOwner);
			}
		};
	}
}
