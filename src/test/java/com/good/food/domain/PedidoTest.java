package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoTest {

  @Test
  void testGetsESets() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    Pedido itemPedido = new Pedido(
            uuid,
            "Daniel",
            "123",
            new ArrayList<>(),
            LocalDate.now(),
            LocalDate.now(),
            EStatusPedido.EM_PREPARACAO,
            "asd",
            "321"
    );

    assertEquals(itemPedido.getId(), uuid);
    itemPedido.setId(uuid2);
    assertEquals(itemPedido.getId(), uuid2);

    assertEquals(itemPedido.getNome(), "Daniel");
    itemPedido.setNome("Lucas");
    assertEquals(itemPedido.getNome(), "Lucas");

    assertEquals(itemPedido.getCpf(), "123");
    itemPedido.setCpf("321");
    assertEquals(itemPedido.getCpf(), "321");

    assertEquals(itemPedido.getDataAtualizacao(), LocalDate.now());
    itemPedido.setDataAtualizacao(LocalDate.now().plusDays(1));
    assertEquals(itemPedido.getDataAtualizacao(), LocalDate.now().plusDays(1));

    assertEquals(itemPedido.getDataCriacao(), LocalDate.now());
    itemPedido.setDataCriacao(LocalDate.now().plusDays(1));
    assertEquals(itemPedido.getDataCriacao(), LocalDate.now().plusDays(1));

    assertEquals(itemPedido.getStatus(), EStatusPedido.EM_PREPARACAO);
    itemPedido.setStatus(EStatusPedido.PRONTO);
    assertEquals(itemPedido.getStatus(), EStatusPedido.PRONTO);

    assertEquals(itemPedido.getQrData(), "asd");
    itemPedido.setQrData("dsa");
    assertEquals(itemPedido.getQrData(), "dsa");

    assertEquals(itemPedido.getStatusPagamento(), "321");
    itemPedido.setStatusPagamento("123");
    assertEquals(itemPedido.getStatusPagamento(), "123");

  }
}
