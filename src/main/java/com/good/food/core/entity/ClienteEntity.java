package com.good.food.core.entity;

import java.util.UUID;
import com.good.food.domain.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String nome;
  private String cpf;
  
  public ClienteEntity(Cliente cliente) {
    id = UUID.fromString(cliente.getId());
    nome = cliente.getNome();
    cpf = cliente.getCpf();
  }
  
  public Cliente toDomain() {
    return Cliente.builder()
        .id(id.toString())
        .nome(nome)
        .cpf(cpf)
      .build();
  }
  
}