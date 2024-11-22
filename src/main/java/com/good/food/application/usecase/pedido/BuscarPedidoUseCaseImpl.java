package com.good.food.application.usecase.pedido;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;
  
  @Override
  public Pedido execute(UUID uuid) {
    return pedidoDatabaseGateway.findById(uuid);
  }
}
