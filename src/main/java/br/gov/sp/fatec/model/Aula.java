package br.gov.sp.fatec.model;

import java.util.Date;
import java.util.List;

import javax.management.MXBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.view.View;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name ="aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aula_id")
	@JsonView({View.All.class,View.Alternative.class})
	private Long id;
	
	@Column(name = "aula_nome")
	@JsonView({View.All.class,View.Alternative.class})
	private String nome;
	
	@Column(name = "aula_data")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonView({View.All.class,View.Alternative.class})
	private Date data;
	
	@OneToOne
	@JoinColumn(name="fk_professor_id")
	@JsonView({View.All.class,View.Alternative.class})
	private Professor prof;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
}
