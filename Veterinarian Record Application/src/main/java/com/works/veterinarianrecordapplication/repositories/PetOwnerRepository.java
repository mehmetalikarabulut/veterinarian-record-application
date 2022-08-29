package com.works.veterinarianrecordapplication.repositories;

import com.works.veterinarianrecordapplication.entities.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Integer> {
}
