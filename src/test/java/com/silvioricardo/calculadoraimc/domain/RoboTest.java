package com.silvioricardo.calculadoraimc.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoboTest {
  private Robo robo;

  void criaMockRobo() {
    if(robo == null)
      robo = new Robo("João Soares Silva");
  }

  @BeforeEach
  void setUp() {
    criaMockRobo();
  }

  @Test
  void deveRetornarPrimeiroNome() {
    assertEquals("João", robo.getPrimeiroNome());

  }

  @Test
  void deveRetornarUltimoNome() {
    assertEquals("Silva", robo.getUltimoNome());
  }

  @Test
  void deveRetornarNomeMaisculo() {
    assertEquals("JOÃO SOARES SILVA", robo.getNomeMaiusculo());
  }

  @Test
  void deveRetornarNomeAbreviado() {
    assertEquals("João S. Silva", robo.getNomeAbreviado());
  }

  @Test
  void deveRetornarExcecaoNomeInvalido() {
    assertThrows(IllegalArgumentException.class, () -> new Cliente(null));
    assertThrows(IllegalArgumentException.class, () -> new Cliente(""));
    assertThrows(IllegalArgumentException.class, () -> new Cliente(" "));
  }
}