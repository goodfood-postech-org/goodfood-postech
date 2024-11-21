package com.good.food.application.presenter.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.good.food.domain.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

  private String id;
  private String cpf;
  private String nome;
  private List<ItemPedidoResponse> itemPedido = new ArrayList<>();
  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  private String status;
  private String statusPagamento;
  private String qrData;

  public PedidoResponse(Pedido pedido) {
    this.id = pedido.getId().toString();
    this.cpf = pedido.getCpf();
    this.nome = pedido.getNome();
    this.itemPedido = pedido.getItemPedido().stream().map(ItemPedidoResponse::new).collect(Collectors.toList());
    this.dataAtualizacao = pedido.getDataAtualizacao();
    this.dataCriacao = pedido.getDataCriacao();
    this.status = pedido.getStatus().name;
    this.statusPagamento = pedido.getStatusPagamento();
    this.qrData = pedido.getQrData();
  }
}
