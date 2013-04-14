package br.com.alexandre.comente.sobre.presentation.controller;

import java.util.List;

import org.apache.log4j.Logger;

import br.com.alexandre.comente.sobre.domain.entity.Comentario;
import br.com.alexandre.comente.sobre.domain.repository.ComentarioRepository;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

@Resource
public class ComentarioController {
	
	private final ComentarioRepository comentarioRepository;
	
	private Logger logger = Logger.getLogger(getClass());
	
	public ComentarioController(final ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	@Get
	@Path("/{assunto}")
	public Comentario novo(final String assunto)  {
		logger.info("Novo comentario iniciado");
		final Comentario comentario = new Comentario();
		comentario.setAssunto(assunto);
		return comentario;		
	}
	
	@Post
	@Path("/comentarios")
	public List<Comentario> salvar(final Comentario comentario) {
		logger.info("Salvando comentario");
		
		comentarioRepository.save(comentario);
		
		final List<Comentario> comentarios = comentarioRepository.findByAssunto(comentario.getAssunto());

		return comentarios;
	}
}
