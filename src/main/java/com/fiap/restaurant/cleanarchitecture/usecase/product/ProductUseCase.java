package com.fiap.restaurant.cleanarchitecture.usecase.product;

import com.fiap.restaurant.cleanarchitecture.entity.product.Product;
import com.fiap.restaurant.cleanarchitecture.gateway.product.IProductGateway;
import com.fiap.restaurant.cleanarchitecture.types.dto.product.ProductDTO;
import com.fiap.restaurant.cleanarchitecture.types.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class ProductUseCase {

    public static Product save(ProductDTO productDTO, IProductGateway productGateway) {
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getCategory());
        productGateway.save(product);
        return product;
    }

    public static Product update(Long id, ProductDTO productDTO, IProductGateway productGateway) {
        if (!productGateway.existsById(id)) throw new ResourceNotFoundException("Produto não encontrado");

        Product product = productGateway.getById(id);
        BeanUtils.copyProperties(productDTO, product, "id");
        productGateway.update(id, product);
        return product;
    }

    public static List<Product> list(IProductGateway productGateway) {
        return productGateway.list();
    }

    public static List<Product> findAllByCategory(String category, IProductGateway productGateway) {
        return productGateway.findAllByCategory(category);
    }

    public static void delete(Long id, IProductGateway productGateway) {
        if (!productGateway.existsById(id)) throw new ResourceNotFoundException("Produto não encontrado");

        productGateway.delete(id);
    }
}