package br.com.alexandre.comente.sobre.domain.service;

import com.google.common.base.Strings;

import br.com.alexandre.comente.sobre.domain.entity.Assunto;
import br.com.alexandre.comente.sobre.infrastructure.util.StringUtils;
import br.com.caelum.vraptor.Resource;

@Resource
public class AssuntoService {

	private final StringUtils stringUtils;

	public AssuntoService(final StringUtils stringUtils) {
		this.stringUtils = stringUtils;
	}

	protected String normalizar(String assunto) {
		if (!Strings.isNullOrEmpty(assunto)) {
			assunto = stringUtils.removerAcentos(assunto);
			assunto = stringUtils.normalizarEspacos(assunto);
			assunto = assunto.replaceAll(" ", "-");
			assunto = assunto.toLowerCase();
		}
		return assunto;
	}
	
	public Assunto buscarPelaDescricao(final String descricao) {
		return new Assunto(normalizar(descricao));
	}
}
