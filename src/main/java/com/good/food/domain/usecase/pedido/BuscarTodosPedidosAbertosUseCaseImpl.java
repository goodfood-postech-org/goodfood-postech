package com.good.food.domain.usecase.pedido;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.good.food.domain.entity.Pedido;
import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.presenter.PedidoPresenter;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class BuscarTodosPedidosAbertosUseCaseImpl implements BuscarTodosPedidosAbertosUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final PedidoPresenter pedidoPresenter;

    public List<PedidoResponse> execute() {
        final List<Pedido> pedidos = pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate();
        return pedidos.stream().map(pedidoPresenter::toResponse).collect(Collectors.toList());
    }
}