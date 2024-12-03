package com.good.food.driver.db.repository.entity;

import com.good.food.domain.ItemPedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ItemPedidoEntityImplTest {

  
  @Test
  public void deveCriarNovoEntity() {
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();
    
    assertNotNull(itemPedidoEntity);
  }

  @Test
  public void deveCriarNovoEntityComValores() {
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(
            UUID.randomUUID(),
            UUID.randomUUID(),
            UUID.randomUUID(),
            "",
            "",
            "",
            10,
            BigDecimal.TEN);

    assertNotNull(itemPedidoEntity);
    assertEquals(itemPedidoEntity.getQuantidade(), 10);
    itemPedidoEntity.setQuantidade(null);
    assertEquals(itemPedidoEntity.getQuantidade(), 1);
  }

  @Test
  public void deveCriarNovoEntityToDomain() {
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(
            UUID.randomUUID(),
            UUID.randomUUID(),
            UUID.randomUUID(),
            "",
            "",
            "",
            10,
            BigDecimal.TEN);

    ItemPedido itemPedido = itemPedidoEntity.toDomain();

    assertNotNull(itemPedido);
    assertEquals(itemPedido.getQuantidade(), 10);
  }
  
}
