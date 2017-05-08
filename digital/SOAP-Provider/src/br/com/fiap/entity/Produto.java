package br.com.fiap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqProduto", sequenceName="SQ_TB_PRODUTO",allocationSize=1)
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqProduto")
	private int codigo;
	
	private String nome;
	
	private String tipo;
	
	private float preco;
	
	public Produto() {
		super();
	}

	public Produto(int codigo, String nome, String tipo, float preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}
