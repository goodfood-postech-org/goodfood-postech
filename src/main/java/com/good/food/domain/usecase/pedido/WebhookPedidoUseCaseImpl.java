package com.good.food.domain.usecase.pedido;

import org.springframework.stereotype.Service;

import com.good.food.domain.entity.EStatusPagamentoPedido;
import com.good.food.domain.entity.Pedido;
import com.good.food.domain.gateway.PedidoDatabaseGateway;
import com.good.food.domain.presenter.PedidoPresenter;
import com.good.food.domain.usecase.pedido.response.PedidoResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class WebhookPedidoUseCaseImpl implements WebhookPedidoUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;
    private final PedidoPresenter pedidoPresenter;

    @Override
    public PedidoResponse execute(String idPedido) {
        final Pedido pedido = pedidoDatabaseGateway.findById(idPedido);
        pedido.setStatusPagamento(EStatusPagamentoPedido.PAGO);
        pedidoDatabaseGateway.save(pedido);

        return pedidoPresenter.toResponse(pedido);
    }
}
