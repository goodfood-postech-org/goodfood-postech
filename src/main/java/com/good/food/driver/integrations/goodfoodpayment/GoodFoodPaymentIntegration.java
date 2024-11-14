package com.good.food.driver.integrations.goodfoodpayment;

import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    url = "${food.integration.payment.url}",
    name = "${food.integration.payment.name}"
  )
public interface GoodFoodPaymentIntegration {

  @PostMapping("/pagamento")
  public String obterQRCode(@RequestParam String idPedido, @RequestParam BigDecimal valor);
  
}
