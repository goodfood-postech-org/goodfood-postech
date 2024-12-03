package com.good.food.application.usecase.pedido;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.good.food.application.gateway.GoodFoodProductGateway;
import com.good.food.application.gateway.ItemPedidoDatabaseGateway;
import com.good.food.domain.ItemPedido;
import com.good.food.domain.Pedido;
import com.good.food.domain.Produto;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CadastrarItemPedidoUseCaseImpl implements CadastrarItemPedidoUseCase {

  private final ItemPedidoDatabaseGateway itemPedidoDatabaseGateway;
  private final GoodFoodProductGateway goodFoodProductGateway;

  @Override
  public ItemPedido execute(final Pedido pedido,
      final ItemPedido itemPedido) {
    final Produto produto = goodFoodProductGateway.obterProduto(itemPedido.getProdutoId());

    itemPedido.setProduto(produto.getId());
    itemPedido.setDescricaoItem(produto.getDescricao());
    itemPedido.setCategoria(produto.getCategoria());
    itemPedido
        .setPreco(produto.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade())));
    itemPedido.setPedido(pedido.getId());
    return itemPedidoDatabaseGateway.save(itemPedido);
  }
}
