package com.works.veterinarianrecordapplication.services;

import com.works.veterinarianrecordapplication.entities.Animal;
import com.works.veterinarianrecordapplication.repositories.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimalService {
    final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public ResponseEntity save(Animal animal) {
        Map<String, Object> hm = new HashMap<>();
        hm.put("animal", animalRepository.save(animal));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("animals", animalRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String id) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(id);
            animalRepository.deleteById(iid);
            hm.put("status", true);
        } catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Animal animal) {
        Map<String, Object> hm = new HashMap<>();
        Optional<Animal> oAnimal = animalRepository.findById(animal.getAid());
        if (oAnimal.isPresent()) {
            animalRepository.saveAndFlush(animal);
            hm.put("message", animal);
            hm.put("status", true);
        } else {
            hm.put("message", "Fail uid");
            hm.put("status", false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String sid) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<Animal> oAnimal = animalRepository.findById(id);
            if (oAnimal.isPresent()) {
                hm.put("status", true);
                hm.put("result", oAnimal.get());
            } else {
                hm.put("status", false);
                hm.put("result", "Empty!");
            }
        } catch (Exception ex) {
            hm.put("message", "id request : " + sid);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchAnimalNameOrPetOwnerName(String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Animal> ls = animalRepository.findByNameContainsIgnoreCaseOrPetOwner_NameContainsIgnoreCase(q,q);
        hm.put("status", true);
        hm.put("animals", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}