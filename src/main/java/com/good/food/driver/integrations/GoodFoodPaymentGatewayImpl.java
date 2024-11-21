package com.good.food.driver.integrations;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.GoodFoodPaymentGateway;
import com.good.food.domain.Pagamento;
import com.good.food.driver.integrations.goodfoodpayment.GoodFoodPaymentIntegration;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoodFoodPaymentGatewayImpl implements GoodFoodPaymentGateway {

  private final GoodFoodPaymentIntegration goodfoodPaymentIntegration;
  
  @Override
  public String obterQRCode(String idPedido, BigDecimal valor) {
    return goodfoodPaymentIntegration.obterQRCode(idPedido, valor);
  }

  @Override
  public Pagamento obterPagamento(String idPedido) {
    return goodfoodPaymentIntegration.obterPagamento(idPedido).toDomain();
  }
  
  

}
