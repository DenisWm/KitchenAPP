package kitchen.project.paratreinar.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cozinha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(mappedBy = "cozinha")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "cozinha")
	private List<Armazenamento> armazenamentos = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "cozinha")
	private List<Receita> receitas = new ArrayList<>();
	
	public Cozinha() {
		
	}

	public Cozinha(Integer id, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
	}
	
	
	
	
}
