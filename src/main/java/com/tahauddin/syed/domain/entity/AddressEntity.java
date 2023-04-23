package com.tahauddin.syed.domain.entity;

import com.tahauddin.syed.domain.MyBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "ADDRESS_TABLE")
@Entity
@Getter
@Setter
public class AddressEntity extends MyBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressLineOne;

    private String addressLineTwo;

    private String city;

    private String state;

    private String country;
}
