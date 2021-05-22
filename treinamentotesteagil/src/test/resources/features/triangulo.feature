Feature: Como um PROFESSOR eu gostaria de IDENTIFICAR OS TIPOS DE TRIÂNGULOS para ENSINÁ-LOS AOS MEUS ALUNOS.

  @Cenario1 @Sanity
  Scenario: Visualizar informacoes do triangulo Equilatero
    Given Estou no navegador "Chrome"
    And Acesso o site "http://vanilton.net/triangulo"
    When Preencho o vértice 1 com "3"
    And Preencho o vértice 2 com "3"
    And Preencho o vértice 3 com "3"
    And Clico no botão identificar
    Then Devo visualizar o resultado de triângulo "Equilátero"

  @Sanity
  Scenario: Visualizar informacoes do triangulo
    Given Estou no navegador "Chrome"
    And Acesso o site "http://vanilton.net/triangulo"
    When Preencho triângulo
      |vertice|valor |
      |1      |3     |
      |2      |3     |
      |3      |3     |
    And Clico no botão identificar
    Then Devo visualizar o resultado de triângulo "Equilátero"


  @Cenario3
  Scenario: Visualizar informacoes do triangulo Isosceles
    Given Estou no navegador "Chrome"
    And Acesso o site "http://vanilton.net/triangulo"
    When Preencho triângulo
      |vertice|valor |
      |1      |8     |
      |2      |8     |
      |3      |3     |
    And Clico no botão identificar
    Then Devo visualizar o resultado de triângulo "Isósceles"
    And E Verifico o valor "8" do Vertice "1"