package com.good.food.adapter.gateway.db.repository.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.good.food.domain.entity.EStatusPagamentoPedido;
import com.good.food.domain.entity.EStatusPedido;
import com.good.food.domain.entity.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "pedido")
public class PedidoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "pedido_id")
  private UUID id;
  @ManyToOne(optional = true, fetch = FetchType.LAZY)
  private ClienteEntity cliente;  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ItemPedidoEntity> itemPedido = new ArrayList<>();

  private LocalDate dataAtualizacao;
  private LocalDate dataCriacao;
  
  private EStatusPedido status;
  private EStatusPagamentoPedido statusPagamento;

  public PedidoEntity(Pedido pedido) {
    id = pedido.getId();
    cliente = Optional.ofNullable(pedido.getCliente()).map(ClienteEntity::new).orElse(null);
    itemPedido = CollectionUtils.emptyIfNull(pedido.getItemPedido())
        .stream()
        .map(ItemPedidoEntity::new)
        .collect(Collectors.toList());
    dataAtualizacao = pedido.getDataAtualizacao();
    dataCriacao = pedido.getDataCriacao();
    status = pedido.getStatus();
    statusPagamento = pedido.getStatusPagamento();
  }
  
  public Pedido toDomain() {
    return Pedido.builder()
        .id(id)
        .cliente(Optional.ofNullable(cliente).map(ClienteEntity::toDomain).orElse(null))
        .itemPedido(
              CollectionUtils.emptyIfNull(itemPedido).stream()
              .map(ItemPedidoEntity::toDomain)
              .collect(Collectors.toList()))        
        .dataAtualizacao(dataAtualizacao)
        .dataCriacao(dataCriacao)
        .status(status)
        .statusPagamento(statusPagamento)
      .build();
  }
  
}
