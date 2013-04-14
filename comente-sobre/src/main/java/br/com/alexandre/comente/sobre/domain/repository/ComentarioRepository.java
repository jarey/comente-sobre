package br.com.alexandre.comente.sobre.domain.repository;

import java.util.List;

import br.com.alexandre.comente.sobre.domain.entity.Comentario;

public interface ComentarioRepository {
	public List<Comentario> findByAssunto(final String assunto);
	public void save(final Comentario comentario);
}
