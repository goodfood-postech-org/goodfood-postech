package com.good.food.driver.integrations.goodfoodpayment.response;

import java.io.Serializable;
import com.good.food.domain.Pagamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponse implements Serializable {

  private static final long serialVersionUID = -1433305488086951084L;
  
  private String status;
  
  public Pagamento toDomain() {
    return Pagamento.builder()
          .status(status)
        .build();
  }

}
