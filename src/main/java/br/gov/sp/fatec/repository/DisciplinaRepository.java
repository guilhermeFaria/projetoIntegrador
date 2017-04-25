package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>{
	public List<Disciplina> findAll();
	public Disciplina findById(Long id);
	

}
