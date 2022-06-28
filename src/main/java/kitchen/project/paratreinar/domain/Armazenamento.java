package kitchen.project.paratreinar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import kitchen.project.paratreinar.domain.enums.TipoArmazenamento;

public class Armazenamento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer tipo;

	@ManyToMany(mappedBy = "armazenamentos")
	private List<Produto> produtos = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "cozinha_id")
	private Cozinha cozinha;

	public Armazenamento() {

	}

	public Armazenamento(Integer id, String nome, TipoArmazenamento tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo.getCod();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getTipo() {
		return tipo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Cozinha getCozinha() {
		return cozinha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armazenamento other = (Armazenamento) obj;
		return Objects.equals(id, other.id);
	}

}
