package com.tahauddin.syed.jpa;

import com.tahauddin.syed.domain.entity.AddressEntity;
import com.tahauddin.syed.domain.entity.CustomerEntity;
import com.tahauddin.syed.domain.repository.AddressRepository;
import com.tahauddin.syed.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@Rollback
public class DataLoaderTest {

    @Autowired
    CustomerRepository customerRepository;

    @Mock
    AddressRepository addressRepository;

    @Test
    void m1(){
        assertNotNull(customerRepository);
        assertNotNull(addressRepository);
    }


    @Test
    void customerRepositoryTestOne(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName("Syed");
        customerEntity.setLastName("Tahauddin");
        customerEntity.setEmail("Tahauddin.Syed@gmail.com");

        CustomerEntity save = customerRepository.save(customerEntity);

        assertNotNull(save);
        assertEquals(save.getFirstName(), "Syed");
        assertEquals(save.getLastName(), "Tahauddin");
    }

    @Test
    void customerRepositoryTestTwo(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName("Syed");
        customerEntity.setLastName("Tahauddin");
        customerEntity.setEmail("Tahauddin.Syed@gmail.com");
        customerEntity.setCreatedDate(Timestamp.from(Instant.now()));
        CustomerEntity save = customerRepository.save(customerEntity);

        System.out.println(save.getId());
        System.out.println(save.getFirstName());
        System.out.println(save.getLastName());
        System.out.println(save.getEmail());
        System.out.println(save.getCreatedDate());
        assertThat(save.getCreatedDate()).isNotNull();
        assertThat(save.getId()).isNotNull();
    }


    @Test
    void addressRepositoryTest(){
        AddressEntity addressEntity = new AddressEntity();
        when(addressRepository.save(addressEntity)).thenReturn(addressEntity);
        AddressEntity savedAddressEntity1 = addressRepository.save(addressEntity);
        assertNotNull(savedAddressEntity1);
        assertNull(savedAddressEntity1.getId());
    }


}
