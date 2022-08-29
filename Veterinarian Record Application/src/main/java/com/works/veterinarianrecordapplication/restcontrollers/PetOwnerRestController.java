package com.works.veterinarianrecordapplication.restcontrollers;

import com.works.veterinarianrecordapplication.entities.Animal;
import com.works.veterinarianrecordapplication.entities.PetOwner;
import com.works.veterinarianrecordapplication.services.PetOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petowner")
public class PetOwnerRestController {
    final PetOwnerService petOwnerService;

    public PetOwnerRestController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PetOwner petOwner) {
        return petOwnerService.save(petOwner);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return petOwnerService.list();
    }

    @PutMapping("/update")
    public ResponseEntity update( @RequestBody PetOwner petOwner ) {
        return petOwnerService.update(petOwner);
    }

    @GetMapping("/single")
    public ResponseEntity single( @RequestParam String id ) {
        return petOwnerService.search(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete( @RequestParam String id ) {
        return petOwnerService.delete(id);
    }
}
