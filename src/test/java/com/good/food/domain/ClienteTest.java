package com.good.food.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ClienteTest {

  @Test
  void testGetsESets() {
    UUID uuid = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    Cliente cliente = new Cliente(uuid, "Daniel", "123");

    assertEquals(cliente.getId(), uuid);
    cliente.setId(uuid2);
    assertEquals(cliente.getId(), uuid2);

    assertEquals(cliente.getCpf(), "123");
    cliente.setCpf("321");
    assertEquals(cliente.getCpf(), "321");

    assertEquals(cliente.getNome(), "Daniel");
    cliente.setNome("Lucas");
    assertEquals(cliente.getNome(), "Lucas");
  }

  @Test
  void testBuilder() {
    UUID uuid = UUID.randomUUID();
    Cliente cliente = Cliente.builder().id(uuid).cpf("123").nome("Daniel").build();

    assertEquals(cliente.getId(), uuid);
    assertEquals(cliente.getCpf(), "123");
    assertEquals(cliente.getNome(), "Daniel");
  }
}
