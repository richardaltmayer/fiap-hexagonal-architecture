package com.fiap.restaurant.types.mapper.order;

import com.fiap.restaurant.entity.order.Item;
import com.fiap.restaurant.external.db.order.ItemJpa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item toItem(ItemJpa itemJpa);

}
