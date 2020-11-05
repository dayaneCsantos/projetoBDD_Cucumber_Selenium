 # language: pt
 @unitarios
 Funcionalidade: Aprender Cucumber

	Como um aluno
	Eu quero aprender a utilizar o cucumber
	Para que eu possa autotizar critérios de aceitação


 Cenário:  Deve executar especificação

 Dado que criei o arquivo corretamente
 Quando executá-lo
 Então a especificação o deve finalizar com sucesso


 Cenário: Deve incrementar contador
 
 Dado que o valor do contador é 15
 Quando eu incrementar em 3
 Então o valor do contador será 18
 
  Cenário: Deve incrementar contador
 
  Dado que o valor do contador é 15
  Quando eu incrementar em 15
  Então o valor do contador será 30

  
  Cenário: Deve calcular atraso na entrega
  
  Dado que a entrega e dia 05/04/2018
  Quando a entrega atrasar em 4 dias
  Então a entrega sera efetuada em 09/04/2018

  Cenário: Deve calcular atraso na entrega na china
  
  Dado que a entrega e dia 05/04/2018
  Quando a entrega atrasar em 2 meses
  Então a entrega sera efetuada em 05/06/2018
  
  Cenário: Deve criar steps genéricos para estes passos
  
    Dado que o ticket é AF345
    Dado que o valor da passagem é R$ 230,45
    Dado que o nome do passageiro é "Fulano da Silva"
    Dado que o telefone do passageiro é 9999-9999
    Quando criar os steps
    Então o teste vai funcionar
    
  Cenário: Deve reaproveitar os steps "Dado" do cenário anterior
  
    Dado que o ticket é AB167
    Dado que o ticket especial é AB167
    Dado que o valor da passagem é R$ 1120,23
    Dado que o nome do passageiro é "Cicrano de Oliveira"
    Dado que o telefone do passageiro é 9888-8888

  Cenário: Deve negar todos os steps "Dado" dos cenários anteriores
  
    Dado que o ticket é CD123
    Dado que o ticket é AG1234
    Dado que o valor da passagem é R$ 1.1345,56
    Dado que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Dado que o telefone do passageiro é 1234-5678
    Dado que o telefone do passageiro é 999-2223
