package kitchen.project.paratreinar.domain.enums;

public enum TipoArmazenamento {

	AMBIENTE(1, "ambiente"), REFRIGERADO(2, "refrigerado"), CONGELADO(3, "congelado");

	private int cod;
	private String descricao;
	
	TipoArmazenamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoArmazenamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoArmazenamento x : TipoArmazenamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
		
	
}
