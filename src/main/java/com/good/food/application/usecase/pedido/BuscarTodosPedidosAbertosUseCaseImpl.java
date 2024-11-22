package com.good.food.application.usecase.pedido;

import java.util.List;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.GoodFoodPaymentGateway;
import com.good.food.application.gateway.PedidoDatabaseGateway;
import com.good.food.domain.Pagamento;
import com.good.food.domain.Pedido;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BuscarTodosPedidosAbertosUseCaseImpl implements BuscarTodosPedidosAbertosUseCase {

    private final PedidoDatabaseGateway pedidoDatabaseGateway;

    private final GoodFoodPaymentGateway paymentIntegration;
    
    public List<Pedido> execute() {
        return pedidoDatabaseGateway.findAllByStatusNotFinalizadoOrderByStatusAndDate()
            .stream()
            .map(pedido -> {
              final Pagamento pagamento = paymentIntegration.obterPagamento(pedido.getId().toString());
              pedido.setStatusPagamento(pagamento.getStatus());
              
              return pedido;
            }).toList();
    }
  
}
