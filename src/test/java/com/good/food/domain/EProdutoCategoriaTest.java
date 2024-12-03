package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class EProdutoCategoriaTest {

  @Test
  void test() {
    EProdutoCategoria categoria = EProdutoCategoria.BEBIDA;
    assertEquals(categoria, EProdutoCategoria.BEBIDA);
    EProdutoCategoria categoria2 = EProdutoCategoria.LANCHE;
    assertEquals(categoria2, EProdutoCategoria.LANCHE);
    EProdutoCategoria categoria3 = EProdutoCategoria.SOBREMESA;
    assertEquals(categoria3, EProdutoCategoria.SOBREMESA);
    EProdutoCategoria categoria4 = EProdutoCategoria.ACOMPANHAMENTO;
    assertEquals(categoria4, EProdutoCategoria.ACOMPANHAMENTO);
  }

  @Test
  void testGetByString() {
    EProdutoCategoria categoria = EProdutoCategoria.getByString("BEBIDA");
    assertEquals(categoria, EProdutoCategoria.BEBIDA);
  }

  @Test
  void testGetByStringThrow() {
    assertThrows(IllegalArgumentException.class, () -> EProdutoCategoria.getByString("INVALIDO"));
  }
}
