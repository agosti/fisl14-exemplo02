package br.edu.unoesc.controller;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PessoaDAO;
import br.edu.unoesc.model.Pessoa;

@Resource
public class PessoaController {
	private Result result;
	private PessoaDAO dao;
	
	public PessoaController(Result result, PessoaDAO dao) {
		this.result = result;
		this.dao = dao;
	}
	@Path("/pessoa/lista")
	public void lista() {
		result.include("pessoas", this.dao.findAll());
	}
	@Post
	@Path("/pessoa/salvar")
	public void salvar(Pessoa pessoa) {
		this.dao.save(pessoa);
		result.redirectTo(this).lista();
	}
	@Path("/pessoa/excluir/{pessoa.codigo}")
	public void excluir(Pessoa pessoa) {
		if (pessoa != null && pessoa.getCodigo() != null) {
			this.dao.delete(pessoa.getCodigo());
		}
		result.redirectTo(this).lista();
	}
	@Path("/pessoa/formulario")
	public void formulario() {
	}
	@Path("/pessoa/editar/{pessoa.codigo}")
	public void editar(Pessoa pessoa) {
		Pessoa p = this.dao.findOne(pessoa.getCodigo());
		if (p != null) {
			result.include("pessoa", p);
		}
		result.redirectTo(this).formulario();
	}
}
