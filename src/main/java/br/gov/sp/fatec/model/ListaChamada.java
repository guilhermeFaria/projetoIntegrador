package br.gov.sp.fatec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lista_chamada")
public class ListaChamada {

	@EmbeddedId
	private ListaChamadaID listaChamadaId;
	
	
	
	/*@JoinColumn(name="fk_aula_id")
	private Aula aula;
	
	
	
	@JoinColumn(name="fk_aluno_id")
	private Aluno aluno;
	
	
	
	@OneToOne(cascade = CascadeType.REMOVE)
	



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
	}*/

	public ListaChamadaID getListaChamadaId() {
		return listaChamadaId;
	}

	public void setListaChamadaId(ListaChamadaID listaChamadaId) {
		this.listaChamadaId = listaChamadaId;
	}

	
	
	
}
