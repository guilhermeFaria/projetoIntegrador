package br.gov.sp.fatec.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "presenca")
public class Presenca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView({View.All.class, View.Alternative.class})
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data")	
	@JsonView({View.All.class, View.Alternative.class})
	private Date data;
	
	@OneToOne
	@JoinColumn(name = "fk_aluno")
	@JsonView({View.All.class, View.Alternative.class})
	private Aluno aluno;
	
	
	@OneToOne
	@JoinColumn(name = "fk_disciplina")
	@JsonView({View.All.class, View.Alternative.class})
	private Disciplina disciplina;
	
	@Column(name = "presente")
	@JsonView({View.All.class,View.Alternative.class})
	private Boolean presente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
