package com.fiap.restaurant.cleanarchitecture.external.db.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanCustomerJpaRepository extends JpaRepository<CustomerJpa, Long> {

    CustomerJpa findByEmail(String email);
    CustomerJpa findByCpf(String cpf);

}