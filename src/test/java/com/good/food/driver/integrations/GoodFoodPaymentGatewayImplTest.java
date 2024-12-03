package com.good.food.driver.integrations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.good.food.domain.Pagamento;
import com.good.food.driver.integrations.goodfoodpayment.GoodFoodPaymentIntegration;
import com.good.food.driver.integrations.goodfoodpayment.response.PagamentoResponse;

@ExtendWith(MockitoExtension.class)
public class GoodFoodPaymentGatewayImplTest {

  @InjectMocks
  public GoodFoodPaymentGatewayImpl provider;
  
  @Mock
  public GoodFoodPaymentIntegration paymentIntegration;
  
  @Test
  public void deveObterQRCode() {
    when(paymentIntegration.obterQRCode(anyString(), any())).thenReturn("qrCode");
    provider.obterQRCode(anyString(), any());
  }
  
  @Test
  public void deveObterPagamento() {
    when(paymentIntegration.obterPagamento(anyString())).thenReturn(new PagamentoResponse("Pago"));
    
    Pagamento obterPagamento = provider.obterPagamento(anyString());
    
    assertEquals("Pago", obterPagamento.getStatus());
  }
  
}
