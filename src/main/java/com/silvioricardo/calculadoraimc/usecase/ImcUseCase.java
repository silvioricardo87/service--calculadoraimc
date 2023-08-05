package com.silvioricardo.calculadoraimc.usecase;

import com.silvioricardo.calculadoraimc.domain.Imc;
import com.silvioricardo.calculadoraimc.domain.ImcClassificacao;
import org.springframework.stereotype.Service;

@Service
public class ImcUseCase {

  public Imc calcularImc(Double peso, Double altura) {
    if (peso <= 0 || altura <= 0)
      throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");

    double imc = Math.round(peso / (altura * altura) * 100.0) / 100.0;

    return new Imc(altura, peso, imc, ImcClassificacao.classificar(imc));
  }
}
