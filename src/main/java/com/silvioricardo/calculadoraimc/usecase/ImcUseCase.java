package com.silvioricardo.calculadoraimc.usecase;

import com.silvioricardo.calculadoraimc.domain.Imc;
import com.silvioricardo.calculadoraimc.domain.ImcClassificacao;
import org.springframework.stereotype.Service;

@Service
public class ImcUseCase {

  public Imc calcularImc(Double peso, Double altura) {
    if(peso <= 0 || altura <= 0)
      throw new IllegalArgumentException("Peso e altura devem ser maiores que zero.");

    Double imc = peso / (altura * altura);
    imc = Math.round(imc * 100.0) / 100.0;

    ImcClassificacao classificacao = ImcClassificacao.classificar(imc);

    return new Imc(altura, peso, imc, classificacao);
  }

}
