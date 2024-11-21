package com.good.food.application.usecase.pedido;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pedido;
import com.good.food.driver.integrations.goodfoodpayment.GoodFoodPaymentIntegration;
import com.good.food.driver.integrations.goodfoodpayment.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoDatabaseGateway pedidoDatabaseGateway;

  private final GoodFoodPaymentIntegration foodPaymentIntegration;
  
  @Override
  public Pedido execute(UUID uuid) {
    final Pedido pedido = pedidoDatabaseGateway.findById(uuid);
    
    final PagamentoResponse obterPagamento = foodPaymentIntegration.obterPagamento(pedido.getId().toString());
    pedido.setStatusPagamento(obterPagamento.getStatus());
    
    return pedido;
  }
}
