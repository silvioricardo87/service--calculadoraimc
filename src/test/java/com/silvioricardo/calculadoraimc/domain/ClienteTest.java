package com.silvioricardo.calculadoraimc.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
  private Cliente cliente;

  void criaMockCliente() {
    if(cliente == null)
      cliente = new Cliente("João Soares Silva");
  }

  @BeforeEach
  void setUp() {
    criaMockCliente();
  }

  @Test
  void deveRetornarPrimeiroNome() {
    assertEquals("João", cliente.getPrimeiroNome());
  }

  @Test
  void deveRetornarUltimoNome() {
    assertEquals("Silva", cliente.getUltimoNome());
  }

  @Test
  void deveRetornarNomeMaisculo() {
    assertEquals("JOÃO SOARES SILVA", cliente.getNomeMaiusculo());
  }

  @Test
  void deveRetornarNomeAbreviado() {
    assertEquals("João S. Silva", cliente.getNomeAbreviado());
  }

  @Test
  void deveRetornarExcecaoNomeInvalido() {
    assertThrows(IllegalArgumentException.class, () -> new Cliente(null));
    assertThrows(IllegalArgumentException.class, () -> new Cliente(""));
    assertThrows(IllegalArgumentException.class, () -> new Cliente(" "));
  }
}