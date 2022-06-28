package kitchen.project.paratreinar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Receita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Integer porcoes;

	@ManyToMany(mappedBy = "receitas")
	private List<Produto> produtos = new ArrayList<Produto>();

	@ManyToOne
	@JoinColumn(name = "cozinha_id")
	private Cozinha cozinha;

	@ElementCollection
	@CollectionTable(name = "Passo")
	private Set<String> passos = new HashSet<String>();

	public Receita() {
	}

	public Receita(Integer id, String nome, String descricao, Integer porcoes) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.porcoes = porcoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(Integer porcoes) {
		this.porcoes = porcoes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cozinha getCozinha() {
		return cozinha;
	}

	public void setCozinha(Cozinha cozinha) {
		this.cozinha = cozinha;
	}

	public Set<String> getPassos() {
		return passos;
	}

	public void setPassos(Set<String> passos) {
		this.passos = passos;
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
		Receita other = (Receita) obj;
		return Objects.equals(id, other.id);
	}

}
