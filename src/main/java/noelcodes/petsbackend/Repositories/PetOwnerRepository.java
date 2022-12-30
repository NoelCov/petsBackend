package noelcodes.petsbackend.Repositories;

import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, Long> {
    // Any custom methods we want to add go here.
}
