package br.com.alexandre.comente.sobre.infrastructure.util;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.alexandre.comente.sobre.infrastructure.util.StringUtils;

public class StringUtilsTest {

	private StringUtils utils = new StringUtils();
	
	@Test
	public void deveriaRemoverOsAcentosDaString() {
		final String texto = "Métodos Ágeis";
		final String esperado = "Metodos Ageis";
		final String real = utils.removerAcentos(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
	}
	
	@Test
	public void deveriaNaoModificarAstring() {
		final String texto = "Spring Framework";
		final String esperado = "Spring Framework";
		final String real = utils.removerAcentos(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
	}
	
	@Test
	public void deveriaRetornarUmaStringComSomenteEspacosDeUmCaractere() {
		final String texto = "Domain     Driven   Design";
		final String esperado = "Domain Driven Design";
		final String real = utils.normalizarEspacos(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
	}

	@Test
	public void deveriaManterAstringComSomenteUmEspaco() {
		final String texto = "Domain Driven Design";
		final String esperado = "Domain Driven Design";
		final String real = utils.normalizarEspacos(texto);
		assertNotNull(real);
		assertEquals(esperado, real);
	}
}
