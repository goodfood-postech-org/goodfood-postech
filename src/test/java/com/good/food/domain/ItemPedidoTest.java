package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ItemPedidoTest {

  @Test
  void testGetsESets() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    UUID uuidPedido = UUID.randomUUID();
    UUID uuidPedido2 = UUID.randomUUID();
    UUID uuidProduto = UUID.randomUUID();
    UUID uuidProduto2 = UUID.randomUUID();
    ItemPedido itemPedido = new ItemPedido(uuid, uuidPedido, "123", uuidProduto, "desc", "cat", "obs", 5, BigDecimal.TEN);

    assertEquals(itemPedido.getId(), uuid);
    itemPedido.setId(uuid2);
    assertEquals(itemPedido.getId(), uuid2);

    assertEquals(itemPedido.getPedido(), uuidPedido);
    itemPedido.setPedido(uuidPedido2);
    assertEquals(itemPedido.getPedido(), uuidPedido2);

    assertEquals(itemPedido.getProduto(), uuidProduto);
    itemPedido.setProduto(uuidProduto2);
    assertEquals(itemPedido.getProduto(), uuidProduto2);

    assertEquals(itemPedido.getDescricaoItem(), "desc");
    itemPedido.setDescricaoItem("desc2");
    assertEquals(itemPedido.getDescricaoItem(), "desc2");

    assertEquals(itemPedido.getCategoria(), "cat");
    itemPedido.setCategoria("cat2");
    assertEquals(itemPedido.getCategoria(), "cat2");

    assertEquals(itemPedido.getObservacoes(), "obs");
    itemPedido.setObservacoes("obs2");
    assertEquals(itemPedido.getObservacoes(), "obs2");

    assertEquals(itemPedido.getQuantidade(), 5);
    itemPedido.setQuantidade(10);
    assertEquals(itemPedido.getQuantidade(), 10);

    assertEquals(itemPedido.getPreco(), BigDecimal.TEN);
    itemPedido.setPreco(BigDecimal.ONE);
    assertEquals(itemPedido.getPreco(), BigDecimal.ONE);

    assertEquals(itemPedido.obterTotalItem(), BigDecimal.TEN);
  }
}
