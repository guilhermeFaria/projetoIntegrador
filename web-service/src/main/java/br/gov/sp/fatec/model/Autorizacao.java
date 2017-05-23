package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name="autorizacao")
public class Autorizacao implements GrantedAuthority{
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "autorizacao", nullable = false)
	private String autorizacao;
	
	public Long getId() {
		return id;
	}

	public String getAutorizacao() {
		return autorizacao;
	}


	@JsonIgnore
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.autorizacao;
	}
}
