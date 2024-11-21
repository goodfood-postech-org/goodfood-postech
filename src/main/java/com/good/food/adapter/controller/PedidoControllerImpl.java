package com.good.food.adapter.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.good.food.application.presenter.pedido.ItemPedidoRequest;
import com.good.food.application.presenter.pedido.PedidoPresenter;
import com.good.food.application.presenter.pedido.PedidoRequest;
import com.good.food.application.presenter.pedido.PedidoResponse;
import com.good.food.application.usecase.pedido.AvancarStatusUseCase;
import com.good.food.application.usecase.pedido.BuscarPedidoUseCase;
import com.good.food.application.usecase.pedido.BuscarTodosPedidosAbertosUseCase;
import com.good.food.application.usecase.pedido.CadastrarPedidoUseCase;
import com.good.food.application.usecase.pedido.RegredirStatusUseCase;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoControllerImpl implements PedidoController {

  private final CadastrarPedidoUseCase cadastrarPedido;
  private final AvancarStatusUseCase avancarStatus;
  private final RegredirStatusUseCase regredirStatus;
  private final BuscarTodosPedidosAbertosUseCase buscarTodosPedidosAbertos;
  private final BuscarPedidoUseCase buscarPedidoUseCase;
  private final PedidoPresenter pedidoPresenter;

  @Override
  public PedidoResponse regredirStatus(String id) {
    return pedidoPresenter.toResponse(regredirStatus.execute(id));
  }
  
  @Override
  public PedidoResponse avancarStatus(String id) {
    return pedidoPresenter.toResponse(avancarStatus.execute(id));
  }
  
  @Override
  public List<PedidoResponse> retornarTodosPedidosAbertos(){
    return buscarTodosPedidosAbertos.execute().stream()
        .map(ped -> pedidoPresenter.toResponse(ped))
        .collect(Collectors.toList());
  }
  
  @Override
  public PedidoResponse buscarPedido(String id) {
      return pedidoPresenter.toResponse(buscarPedidoUseCase.execute(UUID.fromString(id)));
  }
  
  @Override
  public PedidoResponse cadastrarPedido(PedidoRequest pedidoRequest) {
    return pedidoPresenter.toResponse(cadastrarPedido.execute(pedidoRequest.toDomain(), 
        pedidoRequest.getItemPedidos().stream().map(ItemPedidoRequest::toDomain).collect(Collectors.toList()),
        pedidoRequest.getClienteCPF()));
  }

  
}
