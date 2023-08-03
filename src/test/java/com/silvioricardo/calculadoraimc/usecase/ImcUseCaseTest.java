package com.silvioricardo.calculadoraimc.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.silvioricardo.calculadoraimc.domain.Imc;
import com.silvioricardo.calculadoraimc.domain.ImcClassificacao;
import org.junit.jupiter.api.Test;

class ImcUseCaseTest {

  private final ImcUseCase imcUseCase = new ImcUseCase();

  @Test
  void deveCalcularImc() {
    Imc resultado = imcUseCase.calcularImc(70.0, 1.75);

    assertEquals(22.86, resultado.getValorImc());
    assertEquals(ImcClassificacao.NORMAL, resultado.getGrauObesidade());
  }

  @Test
  void deveRetornarExcecaoPesoAlturaInvalidos() {
    assertThrows(IllegalArgumentException.class, () -> imcUseCase.calcularImc(-70.0, 1.75));
    assertThrows(IllegalArgumentException.class, () -> imcUseCase.calcularImc(70.0, -1.75));
  }
}
