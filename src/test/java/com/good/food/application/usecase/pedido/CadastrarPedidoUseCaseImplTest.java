package com.good.food.application.usecase.pedido;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.good.food.application.gateway.GoodFoodPaymentGateway;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;

@ExtendWith(MockitoExtension.class)
public class CadastrarPedidoUseCaseImplTest {

  @InjectMocks
  private CadastrarPedidoUseCaseImpl provider;
  @Mock
  private PedidoDatabaseGateway pedidoDatabaseGateway;
  @Mock
  private CadastrarItemPedidoUseCase cadastrarItemPedido;
  @Mock
  private GoodFoodPaymentGateway goodFoodPaymentGateway;
  
  @Test
  public void deveCadastrarPedido() {
    
    Pedido ped = Pedido.builder().id(UUID.randomUUID()).itemPedido(new ArrayList<ItemPedido>()).build();
    ItemPedido itemPed = ItemPedido.builder().quantidade(1).preco(BigDecimal.TEN).build();
    
    ped.getItemPedido().add(itemPed);
    
    when(pedidoDatabaseGateway.save(ped)).thenReturn(ped);
    when(goodFoodPaymentGateway.obterQRCode(any(), any())).thenReturn("qrCode");
    when(cadastrarItemPedido.execute(ped, itemPed)).thenReturn(itemPed);
    
    provider.execute(ped, List.of(itemPed), "123.312.321-55");
  }
  
}
