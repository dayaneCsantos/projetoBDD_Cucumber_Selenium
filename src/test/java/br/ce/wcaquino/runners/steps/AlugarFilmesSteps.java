package br.ce.wcaquino.runners.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.services.AluguelService;
import br.ce.wcaquino.utils.DateUtils;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AlugarFilmesSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel TipoAluguell;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable { 
		filme = new Filme();
		filme.setEstoque(arg1);
	}

	@Dado("^que o preço do aluguel seja R\\$ (\\d+) reais$")
	public void queOPreçoDoAluguelSejaR$Reais(int arg1) throws Throwable {
	    filme.setaluguel(arg1);
	}
	@Dado("^um filme$")
	public void umFilme(DataTable table) throws Throwable {
	  Map<String, String> map = table.asMap(String.class, String.class);
	  filme = new Filme ();
	  filme.setEstoque(Integer.parseInt(map.get("estoque")));
	  filme.setaluguel(Integer.parseInt(map.get("preco")));   
	  String tipo = map.get("tipo");
	  TipoAluguell = tipo.equals("semanal")? TipoAluguel.semanal: tipo.equals("extendido")? TipoAluguel.extendido: TipoAluguel.comum;
	}

	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
			nota = aluguel.alugar(filme, TipoAluguell);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	    
	}

	@Então("^o preço do aluguel será R\\$ (\\d+) reais$")
	public void oPreçoDoAluguelSeráR$Reais(int arg1) throws Throwable {
	   org.junit.Assert.assertEquals(arg1, nota.getPreço());
	}

	@Então("^o estoque do filme será (\\d+) unidade$")
	public void oEstoqueDoFilmeSeráUnidade(int arg1) throws Throwable {
	   org.junit.Assert.assertEquals(arg1, filme.getEstoque() );
	}
	@Então("^não será possivel por falta de estoque$")
	public void nãoSeráPossivelPorFaltaDeEstoque() throws Throwable {
	    org.junit.Assert.assertEquals("Filme sem estoque", erro);
	}
	@Dado("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) throws Throwable {
		TipoAluguell = tipo.equals("semanal")? TipoAluguel.semanal: tipo.equals("extendido")? TipoAluguel.extendido: TipoAluguel.comum;
	}

	@Então("^a data de entrega será em (\\d+) dias?$")
	public void aDataDeEntregaSeráEmDias(int arg1) throws Throwable {
	    Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
	    Date dataReal = nota.getDataEntrega();
	    
	    DateFormat format =  new SimpleDateFormat("dd/MM/yyyy");
	    
	    org.junit.Assert.assertEquals(format.format( dataEsperada), format.format(dataReal));
	}

	@Então("^a pontuação recebida será de (\\d+) pontos$")
	public void aPontuaçãoRecebidaSeráDePontos(int arg1) throws Throwable {
	   org.junit.Assert.assertEquals(arg1, nota.getPontuacao());
	}




}
