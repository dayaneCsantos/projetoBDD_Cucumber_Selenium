package br.ce.wcaquino.services;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {

		if (filme.getEstoque() == 0) {
			throw new RuntimeException("Filme sem estoque");
		}
		NotaAluguel nota = new NotaAluguel();
		switch (tipoAluguel) {
		case comum: {
			nota.setPreço(filme.getAluguel());
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
			nota.setPontuacao(1);
			break;
		}
		case extendido: {
			nota.setPreço(filme.getAluguel() * 2);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
			nota.setPontuacao(2);
			break;
		}
		case semanal: {
			nota.setPreço(filme.getAluguel() * 3);
			nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
			nota.setPontuacao(3);
			break;
		}
		}
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;

	}
}
