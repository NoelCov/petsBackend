package noelcodes.petsbackend.Repositories;

import noelcodes.petsbackend.Models.Pet;
import noelcodes.petsbackend.Models.PetOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
            pet.setName(rs.getString("pets.name"));
            pet.setBreed(rs.getString("pets.breed"));
            pet.setDob(rs.getDate("pets.dob").toLocalDate());
            pet.setFurColor(rs.getString("pets.furColor"));
            pet.setOwner(new PetOwner(rs.getString("owner.firstName"),
                    rs.getString("owners.lastName"),
                    rs.getDate("owners.dob").toLocalDate(),
                    rs.getString("owners.address")));
            return pet;
        });
    }

    public int addPet(String name, String breed, LocalDate dob, String furColor){
        //TODO change this in the future if it's necessary.
//        String queryToFindOwner = "SELECT owner_Id FROM owners WHERE firstName = ? AND lastName = ?";
//        Integer ownerId = jdbcTemplate.queryForObject(queryToFindOwner,
//                (rs, rowNum) -> rs.getInt("owner_Id"),
//                petOwner.getFirstName(), petOwner.getLastName());

        String queryToInsertPet = "INSERT INTO pets (name, breed, dob, furColor) " +
                "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(queryToInsertPet, name, breed, dob, furColor);
    }

}
