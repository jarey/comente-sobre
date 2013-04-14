package br.com.alexandre.comente.sobre.infrastructure.util;

import java.text.Normalizer;

import br.com.caelum.vraptor.Resource;

@Resource
public class StringUtils {

	public String removerAcentos(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		return str;
	}

	public String normalizarEspacos(final String str) {
		return str.replaceAll("\\s{1,}", " ");
	}

}
