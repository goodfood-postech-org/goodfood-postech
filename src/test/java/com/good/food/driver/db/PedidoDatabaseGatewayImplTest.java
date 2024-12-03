package com.good.food.driver.db;

import com.good.food.application.gateway.GoodFoodPaymentGateway;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pagamento;
import com.good.food.domain.Pedido;
import com.good.food.driver.db.repository.PedidoRepository;
import com.good.food.driver.db.repository.entity.PedidoEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoDatabaseGatewayImplTest {

  @InjectMocks
  public PedidoDatabaseGatewayImpl provider;
  
  @Mock
  public PedidoRepository pedidoRepository;
  @Mock
  private GoodFoodPaymentGateway paymentIntegration;
  
  @Test
  public void deveSalvarItemPedido() {
    PedidoEntity pedidoEntity = new PedidoEntity();

    Pedido pedido = Pedido.builder().cpf("123").id(UUID.randomUUID()).status(EStatusPedido.EM_PREPARACAO).nome("Daniel").build();

    when(pedidoRepository.save(any())).thenReturn(pedidoEntity);

    Pedido pedidoRetorno = provider.save(pedido);
    
    assertNotNull(pedidoRetorno);
  }

  @Test
  public void deveProcurarPorIdString() {
    PedidoEntity pedidoEntity = new PedidoEntity();
    UUID pedidoUUID = UUID.randomUUID();
    pedidoEntity.setId(pedidoUUID);
    Optional<PedidoEntity> optionalPedidoEntity = Optional.of(pedidoEntity);

    final Pagamento pagamento = Pagamento.builder().status("Pago").build();

    when(pedidoRepository.findById(any())).thenReturn(optionalPedidoEntity);
    when(paymentIntegration.obterPagamento(anyString())).thenReturn(pagamento);

    Pedido pedidoRetorno = provider.findById(pedidoUUID.toString());

    assertEquals(pedidoRetorno.getStatusPagamento(), "Pago");
  }

  @Test
  public void deveProcurarPorId() {
    PedidoEntity pedidoEntity = new PedidoEntity();
    UUID pedidoUUID = UUID.randomUUID();
    pedidoEntity.setId(pedidoUUID);
    Optional<PedidoEntity> optionalPedidoEntity = Optional.of(pedidoEntity);

    final Pagamento pagamento = Pagamento.builder().status("Pago").build();

    when(pedidoRepository.findById(any())).thenReturn(optionalPedidoEntity);
    when(paymentIntegration.obterPagamento(anyString())).thenReturn(pagamento);

    Pedido pedidoRetorno = provider.findById(pedidoUUID);

    assertEquals(pedidoRetorno.getStatusPagamento(), "Pago");
  }

  @Test
  public void deveProcurarPorStatusNaoFinalizado() {
    when(pedidoRepository.findAllByStatusNotFinalizadoOrderByStatusAndDate()).thenReturn(null);

    List<Pedido> pedidosRetorno = provider.findAllByStatusNotFinalizadoOrderByStatusAndDate();

    assertNotNull(pedidosRetorno);
  }

  
}
