package com.good.food.driver.integrations.goodfoodproduct.response;

import com.good.food.domain.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ProdutoResponseTest {

  @Test
  public void deveCriarResponseProdutoVazio() {
    ProdutoResponse produtoResponse = new ProdutoResponse();

    assertNotNull(produtoResponse);
  }

  @Test
  public void deveCriarResponseProduto() {
    ProdutoResponse produtoResponse = new ProdutoResponse(UUID.randomUUID().toString(), "Pepsi", new BigDecimal(5), "BEBIDA");

    assertNotNull(produtoResponse);
    assertEquals(produtoResponse.getCategoria(), "BEBIDA");

    Produto produto = produtoResponse.toDomain();
    assertNotNull(produto);
    assertEquals(produto.getCategoria(), "BEBIDA");
  }
}
