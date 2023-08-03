package com.silvioricardo.calculadoraimc.domain.entities;

public class EntidadeGenerica {
  private String nome;

  public EntidadeGenerica(String nome) {
    if (nome == null || nome.trim().isEmpty())
      throw new IllegalArgumentException("Entidade inválida");

    this.nome = nome.trim();
  }

  public String getPrimeiroNome() {
    return nome.split(" ")[0];
  }

  public String getUltimoNome() {
    return nome.substring(nome.lastIndexOf(" ") + 1);
  }

  public String getNomeMaiusculo() {
    return nome.toUpperCase();
  }

  public String getNomeAbreviado() {
    String[] nomes = nome.split(" ");

    for (int i = 1; i < nomes.length - 1; i++)
      nomes[i] = nomes[i].charAt(0) + ".";

    return String.join(" ", nomes);
  }
}

