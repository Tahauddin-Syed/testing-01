package com.tahauddin.syed.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ADDRESS_TABLE")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressLineOne;

    private String addressLineTwo;

    private String city;

    private String state;

    private String country;
}
