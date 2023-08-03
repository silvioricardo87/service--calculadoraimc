package com.silvioricardo.calculadoraimc.adapter.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    mockMvc.perform(get("/imc")
      .param("peso", "80")
      .param("altura", "1.80"))
      .andExpect(status().isOk());
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