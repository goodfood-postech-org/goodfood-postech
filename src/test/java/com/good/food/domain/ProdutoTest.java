package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProdutoTest {

  @Test
  void testGetsESets() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    Produto produto = new Produto(uuid, "Pepsi", BigDecimal.TEN, "BEBIDA");

    assertEquals(produto.getId(), uuid);
    produto.setId(uuid2);
    assertEquals(produto.getId(), uuid2);

    assertEquals(produto.getDescricao(), "Pepsi");
    produto.setDescricao("Coca-Cola");
    assertEquals(produto.getDescricao(), "Coca-Cola");

    assertEquals(produto.getPreco(), BigDecimal.TEN);
    produto.setPreco(BigDecimal.ONE);
    assertEquals(produto.getPreco(), BigDecimal.ONE);

    assertEquals(produto.getCategoria(), "BEBIDA");
    produto.setCategoria("LANCHE");
    assertEquals(produto.getCategoria(), "LANCHE");
  }

  @Test
  void testBuilder() {
    UUID uuid = UUID.randomUUID();
    Cliente cliente = Cliente.builder().id(uuid).cpf("123").nome("Daniel").build();

    assertEquals(cliente.getId(), uuid);
    assertEquals(cliente.getCpf(), "123");
    assertEquals(cliente.getNome(), "Daniel");
  }
}
