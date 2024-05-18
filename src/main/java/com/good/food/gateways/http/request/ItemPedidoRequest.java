package com.good.food.gateways.http.request;

import com.good.food.domain.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoRequest {

  private String produtoUUID;
  private String observacoes;
  private int quantidade;

  public ItemPedido toDomain() {
    return ItemPedido.builder().observacoes(observacoes).quantidade(quantidade).build();
  }
}
