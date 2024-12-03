package com.good.food.driver.db;

import com.good.food.domain.ItemPedido;
import com.good.food.driver.db.repository.ItemPedidoRepository;
import com.good.food.driver.db.repository.entity.ItemPedidoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemPedidoDatabaseGatewayImplTest {

  @InjectMocks
  public ItemPedidoDatabaseGatewayImpl provider;
  
  @Mock
  public ItemPedidoRepository itemPedidoRepository;
  
  @Test
  public void deveSalvarItemPedido() {
    ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity();

    ItemPedido itemPedido = ItemPedido.builder().quantidade(1).preco(BigDecimal.TEN).build();

    when(itemPedidoRepository.save(any())).thenReturn(itemPedidoEntity);

    ItemPedido itemPedidoRetorno = provider.save(itemPedido);
    
    assertNotNull(itemPedidoRetorno);
  }
  
}
