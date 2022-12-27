package noelcodes.petsbackend.Repositories;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pet> getPets() {
        String sqlQuery = "SELECT pets.*, owners.* FROM pets JOIN owners ON pets.owner_Id = owners.owner_Id";
        return jdbcTemplate.query(sqlQuery, (rs, rowNum) -> {
            Pet pet = new Pet();
            //TODO This may not work, it might have to be pets.name instead (referencing the table)
            //TODO try after making the endpoint to add pets
            pet.setName(rs.getString("pet.name"));
            pet.setBreed(rs.getString("pet.breed"));
            pet.setDob(rs.getDate("pet.dob").toLocalDate());
            pet.setFurColor(rs.getString("pet.furColor"));
            pet.setOwner(new PetOwner(rs.getString("owner.firstName"), rs.getString("owner.lastName"), rs.getDate("owner.dob").toLocalDate(), rs.getString("owner.adress")));
            return pet;
        });
    }

}
