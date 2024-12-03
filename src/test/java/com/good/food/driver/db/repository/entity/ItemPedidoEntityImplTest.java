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
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    UUID uuidPedido = UUID.randomUUID();
    UUID uuidPedido2 = UUID.randomUUID();
    UUID uuidProduto = UUID.randomUUID();
    UUID uuidProduto2 = UUID.randomUUID();

    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(
            uuid,
            uuidPedido,
            uuidProduto,
            "desc",
            "cat",
            "obs",
            10,
            BigDecimal.TEN);

    assertNotNull(itemPedidoEntity);
    assertEquals(itemPedidoEntity.getQuantidade(), 10);
    itemPedidoEntity.setQuantidade(null);
    assertEquals(itemPedidoEntity.getQuantidade(), 1);
    itemPedidoEntity.setQuantidade(0);
    assertEquals(itemPedidoEntity.getQuantidade(), 1);

    assertEquals(itemPedidoEntity.getPreco(), BigDecimal.TEN);
    itemPedidoEntity.setPreco(BigDecimal.ONE);
    assertEquals(itemPedidoEntity.getPreco(), BigDecimal.ONE);

    assertEquals(itemPedidoEntity.getDescricao(), "desc");
    itemPedidoEntity.setDescricao("desc2");
    assertEquals(itemPedidoEntity.getDescricao(), "desc2");

    assertEquals(itemPedidoEntity.getCategoria(), "cat");
    itemPedidoEntity.setCategoria("cat2");
    assertEquals(itemPedidoEntity.getCategoria(), "cat2");

    assertEquals(itemPedidoEntity.getObservacoes(), "obs");
    itemPedidoEntity.setObservacoes("obs2");
    assertEquals(itemPedidoEntity.getObservacoes(), "obs2");

    assertEquals(itemPedidoEntity.getPedido(), uuidPedido);
    itemPedidoEntity.setPedido(uuidPedido2);
    assertEquals(itemPedidoEntity.getPedido(), uuidPedido2);

    assertEquals(itemPedidoEntity.getProduto(), uuidProduto);
    itemPedidoEntity.setProduto(uuidProduto2);
    assertEquals(itemPedidoEntity.getProduto(), uuidProduto2);

    assertEquals(itemPedidoEntity.getId(), uuid);
    itemPedidoEntity.setId(uuid2);
    assertEquals(itemPedidoEntity.getId(), uuid2);
  }

  @Test
  public void deveCriarNovoEntityToDomain() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    UUID uuidPedido = UUID.randomUUID();
    UUID uuidPedido2 = UUID.randomUUID();
    UUID uuidProduto = UUID.randomUUID();
    UUID uuidProduto2 = UUID.randomUUID();
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(
            UUID.randomUUID(),
            UUID.randomUUID(),
            UUID.randomUUID(),
            "desc",
            "cat",
            "obs",
            10,
            BigDecimal.TEN);

    ItemPedido itemPedido = itemPedidoEntity.toDomain();

    assertNotNull(itemPedido);
    assertEquals(itemPedido.getQuantidade(), 10);
  }

  @Test
  public void deveCriarNovoEntityBuilder() {
    ItemPedidoEntity itemPedidoEntity = ItemPedidoEntity.builder()
            .id(UUID.randomUUID())
            .pedido(UUID.randomUUID())
            .produto(UUID.randomUUID())
            .preco(BigDecimal.TEN)
            .categoria("cat")
            .descricao("desc")
            .observacoes("obs")
            .quantidade(10)
            .build();

    assertNotNull(itemPedidoEntity);
    assertEquals(itemPedidoEntity.getDescricao(), "desc");
  }
  
}
