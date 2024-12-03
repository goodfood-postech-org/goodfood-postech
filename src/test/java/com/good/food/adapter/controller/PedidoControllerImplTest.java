package com.good.food.adapter.controller;

import com.good.food.adapter.presenter.PedidoPresenterImpl;
import com.good.food.application.presenter.pedido.ItemPedidoRequest;
import com.good.food.application.presenter.pedido.PedidoRequest;
import com.good.food.application.presenter.pedido.PedidoResponse;
import com.good.food.application.usecase.pedido.*;
import com.good.food.domain.EStatusPedido;
import com.good.food.domain.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerImplTest {

  @InjectMocks
  public PedidoControllerImpl provider;

  @Mock
  public RegredirStatusUseCase regredirStatus;

  @Mock
  public AvancarStatusUseCase avancarStatus;
  
  @Mock
  public PedidoPresenterImpl pedidoPresenter;

  @Mock
  public BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertosUseCase;

  @Mock
  public BuscarPedidoUseCase buscarPedidoUseCase;

  @Mock
  public CadastrarPedidoUseCase cadastrarPedidoUseCase;

  @Test
  public void deveRegredirStatus() {
    when(pedidoPresenter.toResponse(any())).thenReturn(new PedidoResponse());
    when(regredirStatus.execute(anyString())).thenReturn(Pedido.builder().build());

    PedidoResponse asd = provider.regredirStatus(anyString());

    assertNotNull(asd);
  }

  @Test
  public void deveAvancarStatus() {
    when(pedidoPresenter.toResponse(any())).thenReturn(new PedidoResponse());
    when(avancarStatus.execute(anyString())).thenReturn(Pedido.builder().build());

    PedidoResponse pedidoResponse = provider.avancarStatus(anyString());

    assertNotNull(pedidoResponse);
  }

  @Test
  public void deveRetornarTodosEstadosAbertos() {

    List<Pedido> expectedPedidos = List.of(Pedido.builder().id(UUID.randomUUID()).status(EStatusPedido.PRONTO).build());

    when(buscarTodosPedidosAbertosUseCase.execute()).thenReturn(expectedPedidos);
    when(pedidoPresenter.toResponse(any())).thenReturn(new PedidoResponse());

    List<PedidoResponse> response = provider.retornarTodosPedidosAbertos();

    assertNotNull(response);
    assertEquals(1, response.size());
  }

  @Test
  public void deveBuscarPedido() {
    Pedido pedido = Pedido.builder().id(UUID.randomUUID()).nome("John").build();
    when(buscarPedidoUseCase.execute(any())).thenReturn(pedido);
    when(pedidoPresenter.toResponse(any())).thenReturn(new PedidoResponse());

    assertNotNull(provider.buscarPedido(UUID.randomUUID().toString()));
  }

  @Test
  public void deveCadastrarPedido() {
    Pedido pedido = Pedido.builder().id(UUID.randomUUID()).nome("John").itemPedido(new ArrayList<>()).status(EStatusPedido.PRONTO).build();

    when(pedidoPresenter.toResponse(any())).thenReturn(new PedidoResponse(pedido));
    when(cadastrarPedidoUseCase.execute(any(), anyList(), anyString())).thenReturn(pedido);

    ItemPedidoRequest itemPedidoRequest = new ItemPedidoRequest(UUID.randomUUID().toString(), "obs", 1);
    ArrayList<ItemPedidoRequest> itemsPedido = new ArrayList<>();
    itemsPedido.add(itemPedidoRequest);

    PedidoRequest pedidoRequest = new PedidoRequest("123", "John", itemsPedido);

    assertNotNull(pedidoRequest.getItemPedidos());

    PedidoResponse pedidoResponse = provider.cadastrarPedido(pedidoRequest);
    assertNotNull(pedidoResponse);
    assertEquals(pedidoResponse.getNome(), "John");
  }
}
