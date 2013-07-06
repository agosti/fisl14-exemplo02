package br.edu.unoesc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.model.Pessoa;

public interface PessoaDAO extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNome(String nome);

	List<Pessoa> findByNomeLike(String nome);
	
	List<Pessoa> findByNomeAndCodigo(String nome, Long codigo);
	
	@Query("select p from Pessoa p where p.nome = ?1")
	List<Pessoa> filtraPorVarios(String nome);

}

