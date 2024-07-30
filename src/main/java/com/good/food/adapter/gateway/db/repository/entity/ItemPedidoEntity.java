package com.good.food.adapter.gateway.db.repository.entity;

import java.math.BigDecimal;
import java.util.UUID;
import com.good.food.domain.ItemPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item_pedido")
public class ItemPedidoEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  
  private UUID pedido;
  @ManyToOne
  @JoinColumn(name = "produto_id")
  private ProdutoEntity produto;

  @Column(nullable = true)
  private String observacoes;
  @Column(nullable = true)
  private Integer quantidade;
  private BigDecimal preco;

  public int getQuantidade() {
    if(quantidade == null || quantidade == 0){
      quantidade = 1;
    }
    return quantidade;
  }
  
  public ItemPedidoEntity(ItemPedido itemPedido) {
    id = itemPedido.getId();
    pedido = itemPedido.getPedido();
    produto = new ProdutoEntity(itemPedido.getProduto());
    observacoes = itemPedido.getObservacoes();
    quantidade = itemPedido.getQuantidade();
    preco = itemPedido.getPreco();
  }
  
  public ItemPedido toDomain() {
    return ItemPedido.builder()
        .id(id)
        .produto(produto.toDomain())
        .pedido(pedido)
        .preco(preco)
        .quantidade(quantidade)
        .observacoes(observacoes)
      .build();
  }
  
}
