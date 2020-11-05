package br.ce.wcaquino.runners.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;

import br.ce.wcaquino.runners.converters.DateConvertet;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {
	
	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {

	}

	@Então("^a especificação o deve finalizar com sucesso$")
	public void aEspecificaçãoODeveFinalizarComSucesso() throws Throwable {

	}
	
	private int contador= 0;
			
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
		contador=arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador=contador+arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
		System.out.println("\nValor esperado:"+arg1);
		System.out.println("Valor resultante:"+contador);
		//Assert.assertTrue(contador==arg1);
		Assert.assertEquals(arg1, contador);
		//throw new RuntimeException();
	}
	
		java.util.Date entrega = new java.util.Date();
		
		@Dado("^que a entrega e dia (.*)$")
		public void queAEntregaEDia(@Transform(DateConvertet.class)java.util.Date data) throws Throwable {
		    entrega = data;
		}

		@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
		public void aEntregaAtrasarEmDias(int dia, String tempo) throws Throwable {
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(entrega);
		    if(tempo.equals("dias"))
		    {
			    cal.add(Calendar.DAY_OF_MONTH, dia);
		    }
		    if(tempo.equals("meses"))
		    {
		    	cal.add(Calendar.MONTH, dia);
		    }
		    entrega = cal.getTime();
		}

		@Então("^a entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
		public void aEntregaSeraEfetuadaEm(String data) throws Throwable {
		   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		   String dataFormatada = format.format(entrega);
		   Assert.assertEquals(data, dataFormatada);
		}
		
		
		@Dado("^que o ticket( especial)? é (A.\\d{3})$")
		public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
		}

		@Dado("^que o valor da passagem é R\\$ (.*)$")
		public void queOValorDaPassagemÉR$(double arg1) throws Throwable {
		   
		}

		@Dado("^que o nome do passageiro é \\\"(.{5,20})\\\"$")
		public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
		    
		}

		@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
		public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
		}

		@Quando("^criar os steps$")
		public void criarOsSteps() throws Throwable {

		}

		@Então("^o teste vai funcionar$")
		public void oTesteVaiFuncionar() throws Throwable {
			
		}


	}

	
