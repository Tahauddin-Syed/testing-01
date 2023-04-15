package com.tahauddin.syed.domain.repository;

import com.tahauddin.syed.domain.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
