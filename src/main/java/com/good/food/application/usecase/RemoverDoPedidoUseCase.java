package com.good.food.application.usecase;

import java.util.List;
import com.good.food.application.entity.Pedido;

public interface RemoverDoPedidoUseCase {

  Pedido execute(final String uuidPedido, final List<String> itemsToBeRemoved);
  
}