package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PagamentoTest {

  @Test
  void testGetsESets() {
    String uuid = UUID.randomUUID().toString();
    String uuid2 = UUID.randomUUID().toString();
    Pagamento pagamento = new Pagamento(uuid, "Pago");

    assertEquals(pagamento.getIdPedido(), uuid);
    pagamento.setIdPedido(uuid2);
    assertEquals(pagamento.getIdPedido(), uuid2);

    assertEquals(pagamento.getStatus(), "Pago");
    pagamento.setStatus("Pendente");
    assertEquals(pagamento.getStatus(), "Pendente");

  }

  @Test
  void testBuilder() {
    Pagamento pagamento = Pagamento.builder().status("Pago").idPedido("123").build();

    assertEquals(pagamento.getStatus(), "Pago");
    assertEquals(pagamento.getIdPedido(), "123");
  }
}
