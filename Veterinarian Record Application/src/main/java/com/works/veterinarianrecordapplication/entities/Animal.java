package com.works.veterinarianrecordapplication.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;

    private String species;
    private String genus;
    private String name;
    private Integer age;
    private String definition;

    @ManyToOne
    private PetOwner petOwner;
}
