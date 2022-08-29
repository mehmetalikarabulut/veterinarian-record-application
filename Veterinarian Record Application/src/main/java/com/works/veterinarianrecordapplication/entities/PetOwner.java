package com.works.veterinarianrecordapplication.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String name;
    private String surname;
    private String email;
    private String phone;
}
