package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
	
	public List<Professor> findAll();
	
	public Professor findById(Long id);
	
	@Query("from Professor p where p.nome like %?1%")
	public List<Professor> searchByNome(String nome);

}
