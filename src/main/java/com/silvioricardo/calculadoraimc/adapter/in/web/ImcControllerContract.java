package com.silvioricardo.calculadoraimc.adapter.in.web;

import com.silvioricardo.calculadoraimc.domain.Imc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "IMC", description = "Endpoint para cálculo do IMC")
public interface ImcControllerContract {
  @Operation(summary = "Calcula o IMC com base na altura e peso informados")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Sucesso", content = @Content(schema = @Schema(implementation = Imc.class))),
      @ApiResponse(responseCode = "400", description = "Requisição mal-formatada"),
      @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
  })
  @GetMapping("/imc")
  Imc calcularImc(@RequestParam(required = true) Double peso, @RequestParam(required = true) Double altura);
}
