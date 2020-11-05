package br.ce.wcaquino.runners.converters;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.Transformer;

public class DateConvertet extends Transformer<Date>{

	@Override
	public Date transform(String arg0) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date retorno = format.parse(arg0);
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	
	

}
