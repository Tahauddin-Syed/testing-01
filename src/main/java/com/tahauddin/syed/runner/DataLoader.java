package com.tahauddin.syed.runner;

import com.tahauddin.syed.domain.constant.CustomerConstants;
import com.tahauddin.syed.domain.constant.OrderTypeEnum;
import com.tahauddin.syed.domain.entity.AddressEntity;
import com.tahauddin.syed.domain.entity.CustomerEntity;
import com.tahauddin.syed.domain.entity.OrderEntity;
import com.tahauddin.syed.domain.repository.AddressRepository;
import com.tahauddin.syed.domain.repository.CustomerRepository;
import com.tahauddin.syed.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLineOne("221 B");
        addressEntity.setAddressLineTwo("Baker Street");
        addressEntity.setCity("London");
        addressEntity.setState("London");
        addressEntity.setCountry("UK");
        addressRepository.save(addressEntity);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setEmail("bond.james007@gmail.com");
        customerEntity.setFirstName("James");
        customerEntity.setLastName("Bond-007");
        customerEntity.setCustomerPhoneNumber("007");
        customerEntity.setAddressEntity(addressEntity);
        customerRepository.save(customerEntity);

        OrderEntity januaryOrder = new OrderEntity();
        januaryOrder.setOrderName("ORDER-"+ RandomStringUtils.random(10));
        januaryOrder.setOrderId("ORID"+RandomStringUtils.random(10, false, true));
        januaryOrder.setOrderPrice("40000");
        januaryOrder.setOrderName("JANUARY-ORDER");
        januaryOrder.setOrderTypeEnum(OrderTypeEnum.NORMAL);
        januaryOrder.setCustomerId(customerEntity);

        OrderEntity febOrder = new OrderEntity();
        febOrder.setOrderName("ORDER-"+ RandomStringUtils.random(10));
        febOrder.setOrderId("ORID"+RandomStringUtils.random(10, false, true));
        febOrder.setOrderPrice("50000");
        febOrder.setOrderName("FEB-ORDER");
        febOrder.setOrderTypeEnum(OrderTypeEnum.EXPRESS);
        febOrder.setCustomerId(customerEntity);

        OrderEntity marOrder = new OrderEntity();
        marOrder.setOrderName("ORDER-"+ RandomStringUtils.random(10));
        marOrder.setOrderId("ORID"+RandomStringUtils.random(10, false, true));
        marOrder.setOrderPrice("60000");
        marOrder.setOrderName("MARCH-ORDER");
        marOrder.setOrderTypeEnum(OrderTypeEnum.SUPER_EXPRESS);
        marOrder.setCustomerId(customerEntity);
        customerEntity.setOrderEntity(List.of(januaryOrder, febOrder, marOrder));
        orderRepository.saveAll(List.of(januaryOrder, febOrder, marOrder));

        customerRepository.save(customerEntity);

        log.info("Order Entity Saved :: {}", orderRepository.count());
    }
}
