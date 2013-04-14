package br.com.alexandre.comente.sobre.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value={
	@NamedQuery(name="Comentario.findByAssunto", query="Select c From Comentario c Where c.assunto = :assunto")
})
public class Comentario implements Serializable {
	
	private static final long serialVersionUID = -3993830672271236972L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=100)
	private String email;
	
	@Column(length=4000)
	private String texto;
	
	@Column(length=100)
	private String assunto;

	public Comentario() {		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", email=" + email + ", texto=" + texto
				+ ", assunto=" + assunto + "]";
	}
	
}
