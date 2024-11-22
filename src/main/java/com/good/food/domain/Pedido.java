package com.good.food.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Pedido {

  private UUID id;
  private String nome;
  private String cpf;
  private List<ItemPedido> itemPedido;
  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  private EStatusPedido status;
  private String qrData;
  private String statusPagamento;
  
  public BigDecimal obterTotalPedido() {
    return itemPedido.stream().map(ItemPedido::obterTotalItem).reduce(BigDecimal.ZERO, BigDecimal::add);
  }
  
}
