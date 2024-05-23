package com.good.food.core.ports.inbound;

import com.good.food.adapter.inbound.controller.request.PedidoRequest;
import com.good.food.core.domain.Pedido;
import jakarta.transaction.Transactional;


public interface CadastrarPedidoUseCase {

  Pedido execute(PedidoRequest pedidoRequest);

}