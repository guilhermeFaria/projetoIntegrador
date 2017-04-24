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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;

@Entity
@Table(name = "aula")
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "data")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonView({View.All.class, View.Alternative.class})
	private Date data;
	
	@OneToOne
	@JoinColumn(name = "fk_professor")
	private Professor professor;
	
	@OneToOne
	@JoinColumn(name = "fk_disciplina")
	private Disciplina disciplina;
	
}
