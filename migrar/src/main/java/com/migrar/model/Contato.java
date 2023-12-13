package com.migrar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long idContato;
	private String nomeContato;
	private String emailContato;
	private String telefoneContato;
	private String mensagemContato;

	public Contato() {

	}

	public Contato(Long idContato, String nomeContato, String emailContato, String telefoneContato,
			String mensagemContato) {
		this.idContato = idContato;
		this.nomeContato = nomeContato;
		this.emailContato = emailContato;
		this.telefoneContato = telefoneContato;
		this.mensagemContato = mensagemContato;
	}

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getMensagemContato() {
		return mensagemContato;
	}

	public void setMensagemContato(String mensagemContato) {
		this.mensagemContato = mensagemContato;
	}

}
