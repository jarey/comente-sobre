package br.com.alexandre.comente.sobre.infrastructure.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import br.com.alexandre.comente.sobre.domain.entity.Comentario;
import br.com.alexandre.comente.sobre.domain.repository.ComentarioRepository;
import br.com.caelum.vraptor.Resource;

@Resource
public class ComentarioDAO implements ComentarioRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public List<Comentario> findByAssunto(final String assunto) {
		logger.info("Iniciando busca de comentarios por assunto");
		
		final TypedQuery<Comentario> typedQuery = entityManager.createNamedQuery("Comentario.findByAssunto", Comentario.class);
		typedQuery.setParameter("assunto", assunto);
		
		final List<Comentario> resultList = typedQuery.getResultList();
		
		logger.info("Finalizando busca de comentarios por assunto");
		return resultList;
	}

	@Transactional
	@Override
	public void save(Comentario comentario) {
		logger.info("Iniciando salvamento de comentario");
		entityManager.persist(comentario);
		logger.info("Finalizando salvamento de comentario");		
	}

	protected void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
