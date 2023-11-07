package com.fiap.restaurant.controller.order;

import com.fiap.restaurant.entity.order.Order;
import com.fiap.restaurant.entity.order.OrderPaymentStatus;
import com.fiap.restaurant.entity.order.OrderStatus;
import com.fiap.restaurant.gateway.customer.CustomerGateway;
import com.fiap.restaurant.gateway.customer.ICustomerGateway;
import com.fiap.restaurant.gateway.order.IItemGateway;
import com.fiap.restaurant.gateway.order.IOrderItemGateway;
import com.fiap.restaurant.gateway.order.ItemGateway;
import com.fiap.restaurant.gateway.order.OrderGateway;
import com.fiap.restaurant.gateway.order.OrderItemGateway;
import com.fiap.restaurant.gateway.payment.IPaymentGateway;
import com.fiap.restaurant.gateway.payment.MercadoPagoGateway;
import com.fiap.restaurant.presenter.order.OrderPresenter;
import com.fiap.restaurant.types.dto.order.OrderScreenPresenterDTO;
import com.fiap.restaurant.types.dto.order.SaveOrderDTO;
import com.fiap.restaurant.types.interfaces.db.customer.CustomerDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.ItemDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.OrderDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.OrderItemDatabaseConnection;
import com.fiap.restaurant.usecase.order.OrderUseCase;

import java.util.List;

public class OrderController {

    public static Order findById(Long id, OrderDatabaseConnection orderDatabaseConnection, CustomerDatabaseConnection customerDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection, customerDatabaseConnection);
        return OrderUseCase.findById(id, orderGateway);
    }

    public static Order updatePaymentStatus(Long id, String paymentStatus, OrderDatabaseConnection orderDatabaseConnection, CustomerDatabaseConnection customerDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection, customerDatabaseConnection);
        OrderPaymentStatus paymentStatusParsed = OrderPaymentStatus.valueOf(paymentStatus);
        return OrderUseCase.updatePaymentStatus(id, paymentStatusParsed, orderGateway);
    }

    public static Order updateStatus(Long id, String status, OrderDatabaseConnection orderDatabaseConnection, CustomerDatabaseConnection customerDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection, customerDatabaseConnection);
        OrderStatus statusParsed = OrderStatus.valueOf(status);
        return OrderUseCase.updateStatus(id, statusParsed, orderGateway);
    }

    public static List<OrderScreenPresenterDTO> listOrderedByStatus(OrderDatabaseConnection orderDatabaseConnection, CustomerDatabaseConnection customerDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection, customerDatabaseConnection);
        List<Order> orderList = OrderUseCase.listOrderedByStatus(orderGateway);

        return OrderPresenter.buildOrderScreen(orderList);
    }

    public static Order save(SaveOrderDTO saveOrderDTO, OrderDatabaseConnection orderDatabaseConnection, CustomerDatabaseConnection customerDatabaseConnection, ItemDatabaseConnection itemDatabaseConnection, OrderItemDatabaseConnection orderItemDatabaseConnection) {
        OrderGateway orderGateway = new OrderGateway(orderDatabaseConnection, customerDatabaseConnection);

        IPaymentGateway mercadoPagoGateway = new MercadoPagoGateway();
        ICustomerGateway customerGateway = new CustomerGateway(customerDatabaseConnection);
        IItemGateway itemGateway = new ItemGateway(itemDatabaseConnection);
        IOrderItemGateway orderItemGateway = new OrderItemGateway(orderItemDatabaseConnection, itemDatabaseConnection, orderDatabaseConnection);

        return OrderUseCase.save(saveOrderDTO, orderGateway, mercadoPagoGateway, customerGateway, itemGateway, orderItemGateway);
    }
}
