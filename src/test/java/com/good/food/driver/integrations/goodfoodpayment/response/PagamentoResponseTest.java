package com.good.food.driver.integrations.goodfoodpayment.response;

import com.good.food.domain.Pagamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PagamentoResponseTest {

  @Test
  public void deveCriarResponsePagamentoVazio() {
    PagamentoResponse pagamentoResponse = new PagamentoResponse();

    assertNotNull(pagamentoResponse);
  }

  @Test
  public void deveCriarResponsePagamento() {
    PagamentoResponse pagamentoResponse = new PagamentoResponse("Pronto");

    assertNotNull(pagamentoResponse);
    assertEquals(pagamentoResponse.getStatus(), "Pronto");
    pagamentoResponse.setStatus("Aguardando");
    assertEquals(pagamentoResponse.getStatus(), "Aguardando");

    Pagamento pagamento = pagamentoResponse.toDomain();
    assertNotNull(pagamento);
  }
}
