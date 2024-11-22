package com.good.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Pagamento {

  public String idPedido;
  public String status;
  
}
