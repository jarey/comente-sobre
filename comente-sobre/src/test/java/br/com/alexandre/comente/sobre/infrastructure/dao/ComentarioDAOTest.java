package br.com.alexandre.comente.sobre.infrastructure.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.alexandre.comente.sobre.domain.entity.Comentario;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ComentarioDAOTest {

	@Mock
	private EntityManager entityManager;
	
	@Mock
	private TypedQuery<Comentario> typedQuery;
	
	private ComentarioDAO comentarioDAO;
	
	@Before
	public void setUp() {
		this.comentarioDAO = new ComentarioDAO();
		this.comentarioDAO.setEntityManager(entityManager);
	}
	
	@Test
	public void deveriaUtilizarNamedQueryParaBuscarOsComentariosDaBaseDeDados() {
		final String assunto = "metodos-ageis";
		final List<Comentario> resultList = new ArrayList<Comentario>();
		
		when(entityManager.createNamedQuery("Comentario.findByAssunto", Comentario.class)).thenReturn(typedQuery);
		when(typedQuery.setParameter("assunto", assunto)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(resultList);
		
		final List<Comentario> real = comentarioDAO.findByAssunto(assunto);
		
		assertNotNull(real);
		assertSame(resultList, real);
		
		verify(entityManager,times(1)).createNamedQuery("Comentario.findByAssunto", Comentario.class);
		verify(typedQuery, times(1)).setParameter("assunto", assunto);
		verify(typedQuery, times(1)).getResultList();
	}

	@Test
	public void deveriaMarcarEntidadeParaSerSalvaPeloEntityManager() {
		final Comentario comentario = new Comentario();
		
		doNothing().when(entityManager).persist(comentario);
		
		comentarioDAO.save(comentario);
		
		verify(entityManager, times(1)).persist(comentario);
	}

}
