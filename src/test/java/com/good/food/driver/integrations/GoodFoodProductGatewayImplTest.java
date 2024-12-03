package com.good.food.driver.integrations;

import com.good.food.driver.integrations.goodfoodproduct.GoodFoodProductIntegration;
import com.good.food.driver.integrations.goodfoodproduct.response.ProdutoResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GoodFoodProductGatewayImplTest {

  @InjectMocks
  public GoodFoodProductGatewayImpl provider;
  
  @Mock
  public GoodFoodProductIntegration goodfoodProductIntegration;

  @Test
  public void deveObterProduto() {
    ProdutoResponse produtoResponse = new ProdutoResponse(UUID.randomUUID().toString(), "Pepsi", new BigDecimal(5), "BEBIDA");

    when(goodfoodProductIntegration.obterProduto(anyString())).thenReturn(produtoResponse);

    assertEquals(provider.obterProduto(anyString()).getDescricao(), "Pepsi");
  }
}
