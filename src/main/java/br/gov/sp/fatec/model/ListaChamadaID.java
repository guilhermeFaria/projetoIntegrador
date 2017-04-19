package br.gov.sp.fatec.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Embeddable
public class ListaChamadaID implements Serializable {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lista_chamada_id")
	@JsonView({View.All.class,View.Alternative.class})
	private Long id;
	
	@OneToOne
	@JoinColumn(name="fk_aula_id")
	@JsonView({View.All.class,View.Alternative.class})
	private Aula aula;
	
	
	@OneToOne
	@JoinColumn(name="fk_aluno_id")
	@JsonView({View.All.class,View.Alternative.class})
	private Aluno aluno;


	/*public ListaChamadaID(Aula aula, Aluno aluno) {
		this.aula = aula;
		this.aluno = aluno;
	}*/


	public Aula getAula() {
		return aula;
	}


	public void setAula(Aula aula) {
		this.aula = aula;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof ListaChamadaID)) return false;
		ListaChamadaID lcId = (ListaChamadaID) obj;
		return Objects.equals(getAluno().getId(), lcId.getAluno().getId()) && 
				Objects.equals(getAula().getId(), lcId.getAula().getId()) &&
				Objects.equals(getId(),lcId.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId(),getAluno().getId(),getAula().getId());
	}
	
	
	
	

}
