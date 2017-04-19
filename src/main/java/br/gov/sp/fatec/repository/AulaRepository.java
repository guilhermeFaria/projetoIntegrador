package br.gov.sp.fatec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Aula;

public interface AulaRepository extends CrudRepository<Aula, Long>{
	
	public List<Aula> findAll();
	
	public Aula findById(Long id);
	
	public List<Aula> findByNome(String nome);

}
