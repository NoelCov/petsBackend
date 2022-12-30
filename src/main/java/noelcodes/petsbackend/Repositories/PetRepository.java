package noelcodes.petsbackend.Repositories;

import noelcodes.petsbackend.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    // Any custom methods that we want go here.
}
