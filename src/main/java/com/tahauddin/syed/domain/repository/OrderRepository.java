package com.tahauddin.syed.domain.repository;

import com.tahauddin.syed.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
