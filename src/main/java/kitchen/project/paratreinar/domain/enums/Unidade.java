package kitchen.project.paratreinar.domain.enums;

public enum Unidade {

	KG(1, "kg"), MG(2, "mg"), G(3, "g"), ML(4, "ml"), L(5, "l");

	private int cod;
	private String descricao;
	
	Unidade(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Unidade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Unidade x : Unidade.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
		
	
}
