package com.fiap.restaurant.external.db.order;

import com.fiap.restaurant.types.interfaces.db.order.ItemDatabaseConnection;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemJpaConnection implements ItemDatabaseConnection<ItemJpa> {

    private final ItemJpaRepository itemJpaRepository;

    public ItemJpaConnection(ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public ItemJpa save(ItemJpa item) {
        return this.itemJpaRepository.save(item);
    }

    @Override
    public Optional<ItemJpa> getById(Long id) {
        return this.itemJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.itemJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return itemJpaRepository.existsById(id);
    }
}
