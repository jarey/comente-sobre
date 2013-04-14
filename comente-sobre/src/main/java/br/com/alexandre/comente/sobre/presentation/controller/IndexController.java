package br.com.alexandre.comente.sobre.presentation.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
	@Get
	@Path("/")
	public void index() {		
	}
}
