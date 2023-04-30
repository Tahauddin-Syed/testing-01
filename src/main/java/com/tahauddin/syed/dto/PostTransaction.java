package com.tahauddin.syed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@SuperBuilder
public class PostTransaction  extends BaseTransaction{

    private Long id;

    private String name;

    private Double amount;

    private String fees;

    private String toAccountNumber;

    private String fromAccountNumber;
}
