package com.fiap.restaurant;

import com.fiap.restaurant.external.db.customer.CustomerJpa;
import com.fiap.restaurant.external.db.order.ItemJpa;
import com.fiap.restaurant.external.db.order.ItemProductJpa;
import com.fiap.restaurant.external.db.order.OrderItemJpa;
import com.fiap.restaurant.external.db.product.ImageJpa;
import com.fiap.restaurant.external.db.order.OrderJpa;
import com.fiap.restaurant.external.db.product.ProductJpa;
import com.fiap.restaurant.types.interfaces.db.customer.CustomerDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.ItemDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.ItemProductDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.OrderItemDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.product.ImageDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.order.OrderDatabaseConnection;
import com.fiap.restaurant.types.interfaces.db.product.ProductDatabaseConnection;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tech Challenge - FIAP")
                        .description("Documentação da API utilizada na construção da solução ao desafio técnico proposto na Postech FIAP (Software Architecture)")
                        .version("1.0"));
    }

    @Autowired
    public CustomerDatabaseConnection<CustomerJpa> customerDatabaseConnection;

    @Autowired
    public ProductDatabaseConnection<ProductJpa> productDatabaseConnection;

    @Autowired
    public ImageDatabaseConnection<ImageJpa> imageDatabaseConnection;

    @Autowired
    public OrderDatabaseConnection<OrderJpa> orderDatabaseConnection;
    @Autowired
    public ItemDatabaseConnection<ItemJpa> itemDatabaseConnection;

    @Autowired
    public ItemProductDatabaseConnection<ItemProductJpa> itemProductDatabaseConnection;

    @Autowired
    public OrderItemDatabaseConnection<OrderItemJpa> orderItemDatabaseConnection;

}
