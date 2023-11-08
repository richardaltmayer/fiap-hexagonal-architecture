package com.fiap.restaurant.cleanarchitecture.external.db.order;

import com.fiap.restaurant.cleanarchitecture.types.interfaces.db.order.OrderDatabaseConnection;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderJpaConnection implements OrderDatabaseConnection<OrderJpa> {

    private final CleanOrderJpaRepository orderJpaRepository;

    public OrderJpaConnection(CleanOrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public OrderJpa getById(Long id) {
        return orderJpaRepository.getReferenceById(id);
    }

    @Override
    public OrderJpa save(OrderJpa orderJpa) {
        return this.orderJpaRepository.save(orderJpa);
    }

    @Override
    public List<OrderJpa> listOrderedByStatusAndId() {
        return this.orderJpaRepository.listOrderedByStatusAndId();
    }
}