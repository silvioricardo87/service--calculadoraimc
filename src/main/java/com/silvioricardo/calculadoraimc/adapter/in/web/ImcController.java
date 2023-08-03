package com.silvioricardo.calculadoraimc.adapter.in.web;

import com.silvioricardo.calculadoraimc.adapter.in.exception.BadRequestException;
import com.silvioricardo.calculadoraimc.domain.Imc;
import com.silvioricardo.calculadoraimc.usecase.ImcUseCase;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImcController implements ImcControllerContract {
  private ImcUseCase imcUseCase;

  public ImcController(ImcUseCase imcUseCase) {
    this.imcUseCase = imcUseCase;
  }

  public Imc calcularImc(Double peso, Double altura) {
    if(peso <= 0 || altura <= 0)
      throw new BadRequestException("Peso e altura devem ser maiores que zero.");

    return imcUseCase.calcularImc(peso, altura);
  }
}
