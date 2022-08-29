package com.works.veterinarianrecordapplication.restcontrollers;

import com.works.veterinarianrecordapplication.entities.Animal;
import com.works.veterinarianrecordapplication.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalRestController {
    final AnimalService animalService;

    public AnimalRestController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return animalService.list();
    }

    @PutMapping("/update")
    public ResponseEntity update( @RequestBody Animal animal ) {
        return animalService.update(animal);
    }

    @GetMapping("/single")
    public ResponseEntity single( @RequestParam String id ) {
        return animalService.search(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete( @RequestParam String id ) {
        return animalService.delete(id);
    }

    @GetMapping("/searchAnimalNameOrPetOwnerName")
    public ResponseEntity searchAnimalNameOrPetOwnerName( @RequestParam String q) {
        return animalService.searchAnimalNameOrPetOwnerName(q);
    }
}
