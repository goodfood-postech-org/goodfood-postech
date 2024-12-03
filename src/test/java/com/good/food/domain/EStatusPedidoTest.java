package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EStatusPedidoTest {

  @Test
  void test() {
    EStatusPedido statusPedido = EStatusPedido.PRONTO;
    assertEquals(statusPedido, EStatusPedido.PRONTO);
    EStatusPedido statusPedido2 = EStatusPedido.RECEBIDO;
    assertEquals(statusPedido2, EStatusPedido.RECEBIDO);
    EStatusPedido statusPedido3 = EStatusPedido.FINALIZADO;
    assertEquals(statusPedido3, EStatusPedido.FINALIZADO);
    EStatusPedido statusPedido4 = EStatusPedido.EM_PREPARACAO;
    assertEquals(statusPedido4, EStatusPedido.EM_PREPARACAO);
  }

  @Test
  void testNext() {
    EStatusPedido statusPedido = EStatusPedido.PRONTO;
    assertEquals(statusPedido.next(), EStatusPedido.FINALIZADO);
    assertEquals(statusPedido.next(), EStatusPedido.FINALIZADO);
  }

  @Test
  void testPrevious() {
    EStatusPedido statusPedido = EStatusPedido.EM_PREPARACAO;
    assertEquals(statusPedido.previous(), EStatusPedido.RECEBIDO);
    assertEquals(statusPedido.previous(), EStatusPedido.RECEBIDO);
  }
}
