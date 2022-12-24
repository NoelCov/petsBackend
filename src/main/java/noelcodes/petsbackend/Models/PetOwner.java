package noelcodes.petsbackend.Models;

import java.util.Date;
import java.util.List;

public class PetOwner {
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    private List<Pet> pets;

    public PetOwner() {
    }

    public PetOwner(String firstName, String lastName, Date dob, String address, List<Pet> pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.pets = pets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
