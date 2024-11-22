package com.good.food.driver.integrations.goodfoodpayment;

import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.good.food.driver.integrations.goodfoodpayment.response.PagamentoResponse;

@FeignClient(
    url = "${food.integration.payment.url}",
    name = "${food.integration.payment.name}"
  )
public interface GoodFoodPaymentIntegration {

  @PostMapping("/pagamento")
  public String obterQRCode(@RequestParam String idPedido, @RequestParam BigDecimal valor);
  
  @GetMapping("/pagamento/{idPedido}")
  public PagamentoResponse obterPagamento(@PathVariable String idPedido);
  
}
