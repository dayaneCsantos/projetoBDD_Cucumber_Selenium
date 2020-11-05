# language: pt
@unitarios
Funcionalidade: Alugar filme

	Como um usuário
	Eu quero cadastrar alugueis de filmes
	Para controlar preços e datas de entregas
	
	
Cenário: Deve alugar um filme com sucesso

	Dado um filme 
	| estoque | 2 |
	| preco   | 3 |
	| tipo    | comum  |
	Quando alugar
	Então o preço do aluguel será R$ 3 reais
	E a data de entrega será em 1 dia
	E o estoque do filme será 1 unidade
	
Cenário: Não deve alugar filmes sem estoque

	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possivel por falta de estoque
	E o estoque do filme será 0 unidade
	
Esquema do Cenário: Deve dar condições conforme o tipo do aluguel

	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja R$ <preco> reais
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor> reais
	E a data de entrega será em <qtdDias> dias
	E a pontuação recebida será de <pontuacao> pontos
	
Exemplos: 	
	| preco | tipo      | valor | qtdDias | pontuacao |
	| 4     | extendido |  8    | 3       | 2         |
	| 4     | comum     |  4    | 1       | 1         |
	| 10    | extendido |  20   | 3       | 2         |
	| 5     | semanal   |  15   | 7       | 3         |


	