package com.fiap.restaurant.external.db.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpa, Long> {

    List<ProductJpa> findAllByCategory(String category);

}
