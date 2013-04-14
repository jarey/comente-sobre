package br.com.alexandre.comente.sobre.domain.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import br.com.alexandre.comente.sobre.domain.service.AssuntoService;
import br.com.alexandre.comente.sobre.infrastructure.util.StringUtils;

@RunWith(MockitoJUnitRunner.class)
public class AssuntoServiceTest {

	@Mock
	private StringUtils stringUtils;
	
	private AssuntoService assuntoService;
	
	@Before
	public void setUp() {
		this.assuntoService = new AssuntoService(stringUtils);
	}
	
	@Test
	public void deveriaNormalizarTextoComUmaPalavra() {
		final String texto = "Java";
		
		when(stringUtils.normalizarEspacos(texto)).thenReturn(texto);
		when(stringUtils.removerAcentos(texto)).thenReturn(texto);
		
		final String esperado = "java";
		final String real = assuntoService.normalizar(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
		
		verify(stringUtils, times(1)).normalizarEspacos(texto);
		verify(stringUtils, times(1)).removerAcentos(texto);
	}
	
	@Test
	public void deveriaNormalizarTextoComDuasPalavras() {
		final String texto = "Métodos Ágeis";
		
		when(stringUtils.removerAcentos(texto)).thenReturn("Metodos Ageis");
		when(stringUtils.normalizarEspacos("Metodos Ageis")).thenReturn("Metodos Ageis");
		
		final String esperado = "metodos-ageis";
		final String real = assuntoService.normalizar(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
		
		verify(stringUtils, times(1)).removerAcentos(texto);
		verify(stringUtils, times(1)).normalizarEspacos("Metodos Ageis");		
	}

	@Test
	public void deveriaNormalizarTextoComTresPalavras() {
		final String texto = "Test Driven Development";
		
		when(stringUtils.removerAcentos(texto)).thenReturn(texto);
		when(stringUtils.normalizarEspacos(texto)).thenReturn(texto);

		
		final String esperado  = "test-driven-development";
		final String real = assuntoService.normalizar(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
		
		verify(stringUtils, times(1)).removerAcentos(texto);
		verify(stringUtils, times(1)).normalizarEspacos(texto);		
	}
	
	@Test
	public void deveriaRetornarNullParaParametroNull() {
		final String texto = null;
		
		when(stringUtils.removerAcentos(texto)).thenReturn(texto);
		when(stringUtils.normalizarEspacos(texto)).thenReturn(texto);
		
		final String real = assuntoService.normalizar(texto);
		assertNull(real);
		
		verify(stringUtils, times(0)).removerAcentos(texto);
		verify(stringUtils, times(0)).normalizarEspacos(texto);		
	}
	
	@Test
	public void deveriaRetornarVazioParaParametroVazio() {
		final String texto = "";
		
		when(stringUtils.removerAcentos(texto)).thenReturn(texto);
		when(stringUtils.normalizarEspacos(texto)).thenReturn(texto);
		
		final String esperado = "";
		final String real = assuntoService.normalizar(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
		
		verify(stringUtils, times(0)).removerAcentos(texto);
		verify(stringUtils, times(0)).normalizarEspacos(texto);	
	}
}
