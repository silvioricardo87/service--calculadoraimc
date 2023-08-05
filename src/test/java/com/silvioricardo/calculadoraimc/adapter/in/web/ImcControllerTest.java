package com.silvioricardo.calculadoraimc.adapter.in.web;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.silvioricardo.calculadoraimc.domain.Imc;
import com.silvioricardo.calculadoraimc.domain.ImcClassificacao;
import com.silvioricardo.calculadoraimc.usecase.ImcUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ImcController.class)
class ImcControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ImcUseCase imcUseCase;

  @Test
  void deveCalcularImc() throws Exception {
    Imc mockImc = new Imc(1.80, 80.0, 24.69, ImcClassificacao.NORMAL);

    when(imcUseCase.calcularImc(80.0, 1.80)).thenReturn(mockImc);

    mockMvc.perform(get("/imc")
      .param("peso", "80")
      .param("altura", "1.80"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.altura", is(1.80)))
      .andExpect(jsonPath("$.peso", is(80.0)))
      .andExpect(jsonPath("$.valorImc", is(24.69)))
      .andExpect(jsonPath("$.grauObesidade", is("NORMAL")));
  }

  @Test
  void deveRetornarBadRequestPesoInvalido() throws Exception {
    mockMvc.perform(get("/imc")
            .param("peso", "0")
            .param("altura", "1.80"))
        .andExpect(status().isBadRequest());
  }

  @Test
  void deveRetornarBadRequestAlturaInvalida() throws Exception {
    mockMvc.perform(get("/imc")
            .param("peso", "80")
            .param("altura", "0"))
        .andExpect(status().isBadRequest());
  }
}