# Guia de Instalação

Este guia fornece instruções passo a passo para a instalação e execução do projeto em um ambiente local.

Você pode optar por instalar manualmente ou utilizar o Docker, que criará toda a infraestrutura necessária na sua máquina e executará a aplicação.

## Pré-requisitos
Antes de prosseguir, verifique se o seu ambiente atende aos requisitos abaixo, de acordo com opção de instalação escolhida.

### Repositório Git
Instale o Git e clone o repositório do projeto em:

```
git clone https://github.com/silvioricardo87/service--calculadoraimc
```

## Opção 1: Instalação manual
Requisitos de software:
- Java 17
- Maven 3.6 ou superior

Abra o prompt de comando ou terminal do seu dispositivo, navegue até a pasta onde foi clonado o projeto e execute o comando a seguir:
```bash
mvn spring-boot:run`
```

## Instalação via Docker
Requisitos de software:
- Docker

Abra o prompt de comando ou terminal do seu dispositivo, navegue até a pasta onde foi clonado o projeto e execute o comando a seguir:
``` bash
docker run -p 8080:8080 silvioricardo87/service--calculadoraimc
```

## Documentação
Acesse a documentação da API via Swagger em:
```
http://localhost:8080/swagger-ui.html
```