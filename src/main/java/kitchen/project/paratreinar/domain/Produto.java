package kitchen.project.paratreinar.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import kitchen.project.paratreinar.domain.enums.Unidade;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double pesoVolume;
	private Integer unidade;
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "PRODUTO_ARMAZENAMENTO", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "armazenamento_id"))
	private List<Armazenamento> armazenamentos = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	@JoinTable(name = "PRODUTO_RECEITA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "receita_id"))
	private List<Receita> receitas = new ArrayList<Receita>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeExpiracao;

	public Produto() {

	}

	public Produto(Integer id, String nome, Double pesoVolume, Unidade unidade, String descricao, Date dataDeExpiracao)
			throws ParseException {
		super();
		this.id = id;
		this.nome = nome;
		this.pesoVolume = pesoVolume;
		this.unidade = (unidade == null) ? null : unidade.getCod();
		this.descricao = descricao;
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public Unidade getUnidade() {
		return Unidade.toEnum(unidade);
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade.getCod();
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

	public Double getPesoVolume() {
		return pesoVolume;
	}

	public void setPesoVolume(Double pesoVolume) {
		this.pesoVolume = pesoVolume;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(Date dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
