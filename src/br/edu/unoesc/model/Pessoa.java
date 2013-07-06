package br.edu.unoesc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pessoa {

	@Id
	@SequenceGenerator(name="SEQ_ID_PESSOA",
	sequenceName="PESSOA_ID_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="SEQ_ID_PESSOA")
	private Long codigo;
	private String nome;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
