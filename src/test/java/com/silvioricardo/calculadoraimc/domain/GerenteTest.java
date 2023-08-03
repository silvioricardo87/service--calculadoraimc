package com.silvioricardo.calculadoraimc.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GerenteTest {
private Gerente gerente;

  void criaMockGerente() {
    if(gerente == null)
      gerente = new Gerente("Silvio Ferreira Santos");
  }

  @BeforeEach
  void setUp() {
    criaMockGerente();
  }

  @Test
  void deveRetornarPrimeiroNome() {
    assertEquals("Silvio", gerente.getPrimeiroNome());
  }

  @Test
  void deveRetornarUltimoNome() {
    assertEquals("Santos", gerente.getUltimoNome());
  }

  @Test
  void deveRetornarNomeMaisculo() {
    assertEquals("SILVIO FERREIRA SANTOS", gerente.getNomeMaiusculo());
  }

  @Test
  void deveRetornarNomeAbreviado() {
    assertEquals("Silvio F. Santos", gerente.getNomeAbreviado());
  }

  @Test
  void deveRetornarExcecaoNomeInvalido() {
    assertThrows(IllegalArgumentException.class, () -> new Gerente(null));
    assertThrows(IllegalArgumentException.class, () -> new Gerente(""));
    assertThrows(IllegalArgumentException.class, () -> new Gerente(" "));
  }
}