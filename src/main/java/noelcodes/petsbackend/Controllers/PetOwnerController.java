//package noelcodes.petsbackend.Controllers;
//
//import noelcodes.petsbackend.Models.PetOwner;
//import noelcodes.petsbackend.Services.PetOwnerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path="api/owner")
//public class PetOwnerController {
//
//    private final PetOwnerService petOwnerService;
//
//    @Autowired
//    public PetOwnerController(PetOwnerService petOwnerService) {
//        this.petOwnerService = petOwnerService;
//    }
//
//    @GetMapping("/owners")
//    public List<PetOwner> getOwners() {
//        return petOwnerService.getPetsOwners();
//    }
//}
