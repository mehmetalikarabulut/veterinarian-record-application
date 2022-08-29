package com.works.veterinarianrecordapplication.repositories;

import com.works.veterinarianrecordapplication.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByNameContainsIgnoreCaseOrPetOwner_NameContainsIgnoreCase(String name, String name1);
}
