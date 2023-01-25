package noelcodes.petsbackend.Repositories;

import noelcodes.petsbackend.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByOwnerId(Long ownerId);
    // Any custom methods that we want go here.
}
