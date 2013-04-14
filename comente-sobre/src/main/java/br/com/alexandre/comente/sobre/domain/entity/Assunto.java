package br.com.alexandre.comente.sobre.domain.entity;

import java.io.Serializable;

public class Assunto implements Serializable {

	private static final long serialVersionUID = 7791350474288192851L;

	private final String nome;

	public Assunto(final String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assunto other = (Assunto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assunto [nome=" + nome + "]";
	}
	
}
