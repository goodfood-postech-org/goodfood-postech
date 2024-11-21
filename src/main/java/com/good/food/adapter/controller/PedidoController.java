package com.good.food.adapter.controller;

import java.util.List;

import com.good.food.application.presenter.pedido.PedidoRequest;
import com.good.food.application.presenter.pedido.PedidoResponse;

public interface PedidoController {

    PedidoResponse regredirStatus(String id);

    PedidoResponse avancarStatus(String id);

    List<PedidoResponse> retornarTodosPedidosAbertos();

    PedidoResponse buscarPedido(String id);

    PedidoResponse cadastrarPedido(PedidoRequest pedidoRequest);
    
}
