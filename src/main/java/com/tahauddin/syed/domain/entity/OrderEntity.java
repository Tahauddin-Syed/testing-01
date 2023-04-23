package com.tahauddin.syed.domain.entity;

import com.tahauddin.syed.domain.MyBaseEntity;
import com.tahauddin.syed.domain.constant.OrderTypeEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_TABLE")
@Getter
@Setter
public class OrderEntity extends MyBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    private String orderName;

    private String orderPrice;

    @Enumerated(EnumType.STRING)
    private OrderTypeEnum orderTypeEnum;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerId;
}
