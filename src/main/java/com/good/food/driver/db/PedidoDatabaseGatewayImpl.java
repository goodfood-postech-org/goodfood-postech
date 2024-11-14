package com.good.food.driver.db;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.driver.db.repository.PedidoRepository;
import com.good.food.driver.db.repository.entity.PedidoEntity;
import jakarta.transaction.Transactional;
import com.good.food.domain.Pedido;
import com.good.food.driver.NotFoundException;

@Component
public class PedidoDatabaseGatewayImpl implements PedidoDatabaseGateway {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Override
  @Transactional
  public Pedido save(Pedido pedido) {
    return pedidoRepository.save(new PedidoEntity(pedido)).toDomain();
  }

  @Override
  public Pedido findById(String uuid) {
    return findById(UUID.fromString(uuid));
  }

  @Override
  public Pedido findById(UUID uuid) {
    return pedidoRepository.findById(uuid)
        .map(PedidoEntity::toDomain)
        .orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
  }

  @Override
  public List<Pedido> findAllByStatusNotFinalizadoOrderByStatusAndDate() {
    return CollectionUtils.emptyIfNull(pedidoRepository.findAllByStatusNotFinalizadoOrderByStatusAndDate())
        .stream()
        .map(PedidoEntity::toDomain)
      .collect(Collectors.toList());
  }
}
