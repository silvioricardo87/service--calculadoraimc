package com.silvioricardo.calculadoraimc.domain;

public class Imc {
  private Double altura;
  private Double peso;
  private Double valorImc;
  private ImcClassificacao grauObesidade;

  public Imc() {
    //
  }

  public Imc(Double altura, Double peso, Double valorImc, ImcClassificacao grauObesidade) {
    this.altura = altura;
    this.peso = peso;
    this.valorImc = valorImc;
    this.grauObesidade = grauObesidade;
  }

  public Double getAltura() {
    return altura;
  }

  public void setAltura(Double altura) {
    this.altura = altura;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {
    this.peso = peso;
  }

  public Double getValorImc() {
    return valorImc;
  }

  public void setValorImc(Double valorImc) {
    this.valorImc = valorImc;
  }

  public ImcClassificacao getGrauObesidade() {
    return grauObesidade;
  }

  public void setGrauObesidade(ImcClassificacao grauObesidade) {
    this.grauObesidade = grauObesidade;
  }
}
