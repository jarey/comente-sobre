package br.com.alexandre.comente.sobre.presentation.controller;

import org.apache.log4j.Logger;

import br.com.alexandre.comente.sobre.domain.entity.Assunto;
import br.com.alexandre.comente.sobre.domain.service.AssuntoService;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class AssuntoController {

	private final AssuntoService assuntoService;
	
	private Logger logger = Logger.getLogger(getClass());
	
	private final Result result;
	
	public AssuntoController(final AssuntoService assuntoService, final Result result) {
		this.result = result;
		this.assuntoService = assuntoService;
	}
	
	@Get
	@Path("/assunto/{descricao}")
	public void buscarPelaDescricao(final String descricao) {
		logger.info("Iniciando busca de assunto pela descricao informada");
		final Assunto assunto = assuntoService.buscarPelaDescricao(descricao);
		result.use(Results.json()).withoutRoot().from(assunto).serialize();
	}
	
}
