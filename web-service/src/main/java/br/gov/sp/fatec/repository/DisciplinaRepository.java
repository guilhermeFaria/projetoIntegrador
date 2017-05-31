package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>{
	public List<Disciplina> findAll();
	public Disciplina findById(Long id);
	@Query("from Disciplina d where d.professor.id=?1")
	public List<Disciplina> findByProfessor(Long id);
	

}
