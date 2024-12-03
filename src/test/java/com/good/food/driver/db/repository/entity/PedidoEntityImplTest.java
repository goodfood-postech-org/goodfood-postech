package com.good.food.driver.db.repository.entity;

import com.good.food.domain.EStatusPedido;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PedidoEntityImplTest {

  @Test
  public void deveCriarNovoEntity() {
    PedidoEntity pedidoEntity = new PedidoEntity();
    
    assertNotNull(pedidoEntity);
  }

  @Test
  public void deveCriarNovoEntityComValores() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    PedidoEntity pedidoEntity = new PedidoEntity(
            uuid,
            "Daniel",
            "123",
            new ArrayList<>(),
            LocalDate.now(),
            LocalDate.now(),
            EStatusPedido.RECEBIDO,
            "asd");

    assertNotNull(pedidoEntity);

    assertEquals(pedidoEntity.getId(), uuid);
    pedidoEntity.setId(uuid2);
    assertEquals(pedidoEntity.getId(), uuid2);

    assertEquals(pedidoEntity.getNome(), "Daniel");
    pedidoEntity.setNome("Lucas");
    assertEquals(pedidoEntity.getNome(), "Lucas");

    assertEquals(pedidoEntity.getCpf(), "123");
    pedidoEntity.setCpf("321");
    assertEquals(pedidoEntity.getCpf(), "321");

    assertEquals(pedidoEntity.getDataAtualizacao(), LocalDate.now());
    pedidoEntity.setDataAtualizacao(LocalDate.now().plusDays(1));
    assertEquals(pedidoEntity.getDataAtualizacao(), LocalDate.now().plusDays(1));

    assertEquals(pedidoEntity.getDataCriacao(), LocalDate.now());
    pedidoEntity.setDataCriacao(LocalDate.now().plusDays(1));
    assertEquals(pedidoEntity.getDataCriacao(), LocalDate.now().plusDays(1));

    assertEquals(pedidoEntity.getStatus(), EStatusPedido.RECEBIDO);
    pedidoEntity.setStatus(EStatusPedido.EM_PREPARACAO);
    assertEquals(pedidoEntity.getStatus(), EStatusPedido.EM_PREPARACAO);

    assertEquals(pedidoEntity.getQrData(), "asd");
    pedidoEntity.setQrData("dsa");
    assertEquals(pedidoEntity.getQrData(), "dsa");
  }

  @Test
  public void deveCriarNovoEntityToDomain() {
    PedidoEntity pedidoEntity = new PedidoEntity(
            UUID.randomUUID(),
            "Daniel",
            "123",
            new ArrayList<>(),
            LocalDate.now(),
            LocalDate.now(),
            EStatusPedido.RECEBIDO,
            "asd");

    Pedido pedido = pedidoEntity.toDomain();

    assertNotNull(pedido);
    assertEquals(pedido.getNome(), "Daniel");
  }

  @Test
  public void deveTestarBuilder() {
    PedidoEntity pedidoEntity = PedidoEntity.builder()
            .cpf("123")
            .id(UUID.randomUUID())
            .dataAtualizacao(LocalDate.now())
            .dataCriacao(LocalDate.now())
            .nome("Daniel")
            .itemPedido(new ArrayList<>())
            .qrData("asd")
            .status(EStatusPedido.RECEBIDO)
            .build();

    assertNotNull(pedidoEntity);
    assertEquals(pedidoEntity.getNome(), "Daniel");
  }
  
}
