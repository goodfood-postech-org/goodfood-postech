package com.good.food.application.usecase.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
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
import com.good.food.domain.Pagamento;
import com.good.food.domain.Pedido;

@ExtendWith(MockitoExtension.class)
public class BuscarTodosPedidosAbertosUseCaseImplTest {

  @InjectMocks
  private BuscarTodosPedidosAbertosUseCaseImpl provider;

  @Mock
  private PedidoDatabaseGateway pedidoDatabaseGateway;

  @Mock
  private GoodFoodPaymentGateway goodFoodPaymentGateway;

  @Test
  public void deveRetornarPedidos() {

    Pedido pedido1 = Pedido.builder().cpf("123").id(UUID.randomUUID()).build();
    Pedido pedido2 = Pedido.builder().cpf("456").id(UUID.randomUUID()).build();

    List<Pedido> pedidos = new ArrayList<Pedido>();
    pedidos.add(pedido1);
    pedidos.add(pedido2);
    
    final Pagamento pagamento = Pagamento.builder().status("Pago").build();
    
    when(pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate()).thenReturn(pedidos);

    when(goodFoodPaymentGateway.obterPagamento(anyString())).thenReturn(pagamento);
    
    List<Pedido> findAllPedidos = provider.execute();
    
    findAllPedidos.forEach(ped -> {
      assertEquals("Pago", ped.getStatusPagamento());
    });    
    
  }


}
