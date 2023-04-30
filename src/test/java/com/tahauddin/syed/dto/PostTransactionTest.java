package com.tahauddin.syed.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostTransactionTest {


    @Test
    void testOne(){
        PostTransaction syedTahauddin = PostTransaction.builder()
                .id(1l)
                .amount(3000.00)
                .name("Syed Tahauddin")
                .fromAccountNumber("123456789")
                .toAccountNumber("987654321")
                .createdDate(LocalDate.now())
                .createdBy("SYED")
                .build();

        // assert j test cases
        assertThat(syedTahauddin).satisfies( it -> {
            assertThat(it.getId()).isEqualTo(1l);
            assertThat(it.getName()).isEqualTo("Syed Tahauddin");
            assertThat(it.getAmount()).isEqualTo(3000.00);
            assertThat(it.getCreatedBy()).isEqualTo("SYED");
            assertThat(it.getCreatedDate()).isNotNull();
            assertThat(it.getCreatedDate()).isEqualTo(LocalDate.now());
        });


    }
}
