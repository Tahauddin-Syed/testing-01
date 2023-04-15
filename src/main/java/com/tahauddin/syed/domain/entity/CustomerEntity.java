package com.tahauddin.syed.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String customerPhoneNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL)
    private List<OrderEntity> orderEntity = new ArrayList<>();
}
