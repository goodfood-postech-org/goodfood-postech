package com.good.food.application.usecase.pedido;

import com.good.food.application.gateway.GoodFoodProductGateway;
import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastrarItemPedidoUseCaseImplTest {


  @InjectMocks
  private CadastrarItemPedidoUseCaseImpl provider;
  @Mock
  private GoodFoodProductGateway goodFoodProductGateway;
  @Mock
  private ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;
  
  @Test
  public void deveCadastrarItemPedido() {
    
    Pedido ped = Pedido.builder().id(UUID.randomUUID()).itemPedido(new ArrayList<>()).build();
    ItemPedido itemPedido = ItemPedido.builder().id(UUID.randomUUID()).quantidade(1).preco(BigDecimal.TEN).build();
    UUID uuid = UUID.randomUUID();
    Produto produto = Produto.builder().id(uuid).categoria("BEBIDA").descricao("Pepsi").preco(BigDecimal.TEN).build();
    
    ped.getItemPedido().add(itemPedido);

    when(itemPedidoDatabaseGateway.save(itemPedido)).thenReturn(itemPedido);
    when(goodFoodProductGateway.obterProduto(itemPedido.getProdutoId())).thenReturn(produto);

    ItemPedido itemPedidoRetorno = provider.execute(ped, itemPedido);

    assertEquals(itemPedidoRetorno.getProduto(), uuid);
  }
  
}
