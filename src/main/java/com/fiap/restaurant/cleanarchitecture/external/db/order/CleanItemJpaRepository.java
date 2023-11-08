package com.fiap.restaurant.cleanarchitecture.external.db.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleanItemJpaRepository extends JpaRepository<ItemJpa, Long> {
}