package com.good.food.driver.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.domain.ItemPedido;
import com.good.food.driver.db.repository.ItemPedidoRepository;
import com.good.food.driver.db.repository.entity.ItemPedidoEntity;
import jakarta.transaction.Transactional;

@Component
public class ItemPedidoDatabaseGatewayImpl implements ItemPedidoDatabaseGateway {

  @Autowired
  private ItemPedidoRepository itemPedidoRepository;

  @Override
  @Transactional
  public ItemPedido save(ItemPedido item) {
    return itemPedidoRepository.save(new ItemPedidoEntity(item)).toDomain();
  }
}
