package com.fiap.restaurant.cleanarchitecture.controller.order;

import com.fiap.restaurant.cleanarchitecture.entity.order.Order;
import com.fiap.restaurant.cleanarchitecture.gateway.order.OrderGateway;
import com.fiap.restaurant.cleanarchitecture.types.interfaces.db.order.OrderDatabaseConnection;
import com.fiap.restaurant.cleanarchitecture.usecase.order.OrderUseCase;

public class OrderController {

    public static Order findById(Long id, OrderDatabaseConnection orderDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection);
        return OrderUseCase.findById(id, orderGateway);
    }
}