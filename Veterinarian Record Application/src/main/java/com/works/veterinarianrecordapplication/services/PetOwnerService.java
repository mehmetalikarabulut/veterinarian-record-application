package com.works.veterinarianrecordapplication.services;

import com.works.veterinarianrecordapplication.entities.PetOwner;
import com.works.veterinarianrecordapplication.repositories.PetOwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PetOwnerService {

    final PetOwnerRepository petOwnerRepository;

    public PetOwnerService(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    public ResponseEntity save(PetOwner petOwner) {
        Map<String, Object> hm = new HashMap<>();
        PetOwner pOwner = petOwnerRepository.save(petOwner);
        hm.put("Animal", petOwner);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("Animals", petOwnerRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String id) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(id);
            petOwnerRepository.deleteById(iid);
            hm.put("status", true);
        } catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(PetOwner petOwner) {
        Map<String, Object> hm = new HashMap<>();
        Optional<PetOwner> oPetOwner = petOwnerRepository.findById(petOwner.getPid());
        if (oPetOwner.isPresent()) {
            petOwnerRepository.saveAndFlush(petOwner);
            hm.put("message", petOwner);
            hm.put("status", true);
        } else {
            hm.put("message", "Fail uid");
            hm.put("status", false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search( String sid ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<PetOwner> oPetOwner = petOwnerRepository.findById(id);
            if (oPetOwner.isPresent() ) {
                hm.put("status", true);
                hm.put("result", oPetOwner.get() );
            }else {
                hm.put("status", false);
                hm.put("result", "Empty!" );
            }
        }catch (Exception ex) {
            hm.put("message", "id request : " + sid);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
