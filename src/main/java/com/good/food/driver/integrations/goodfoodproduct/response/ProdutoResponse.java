package com.good.food.driver.integrations.goodfoodproduct.response;

import java.math.BigDecimal;
import java.util.UUID;
import com.good.food.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

  private String id;
  private String descricao;
  private BigDecimal preco;
  private String categoria;
  
  public Produto toDomain() {
    return Produto.builder()
          .id(UUID.fromString(id))
          .descricao(descricao)
          .categoria(categoria)
          .preco(preco)        
        .build();
  }
  
}
