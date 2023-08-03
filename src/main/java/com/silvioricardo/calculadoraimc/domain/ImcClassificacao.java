package com.silvioricardo.calculadoraimc.domain;

public enum ImcClassificacao {
  MAGREZA(0, 18.5),
  NORMAL(0, 24.9),
  SOBREPESO(1, 29.9),
  OBESIDADE(2, 39.9),
  OBESIDADE_GRAVE(3, Double.POSITIVE_INFINITY);

  private final int grauObesidade;
  private final double limit;

  ImcClassificacao(int grauObesidade, double limiteRef) {
    this.grauObesidade = grauObesidade;
    this.limit = limiteRef;
  }

  public static ImcClassificacao classificar(double imc) {
    for (ImcClassificacao c : values()) {
      if (imc < c.limit) return c;
    }
    throw new IllegalArgumentException("Valor de IMC inválido");
  }
}
