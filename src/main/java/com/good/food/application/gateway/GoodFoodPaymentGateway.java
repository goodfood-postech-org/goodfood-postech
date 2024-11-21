package com.good.food.application.gateway;

import java.math.BigDecimal;
import com.good.food.domain.Pagamento;

public interface GoodFoodPaymentGateway {

  String obterQRCode(String idPedido, BigDecimal valor);
  
  Pagamento obterPagamento(String idPedido);
  
  
}
