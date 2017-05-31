package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Presenca;
import br.gov.sp.fatec.model.Aluno;

public interface PresencaRepository extends CrudRepository<Presenca, Long>{
	public List<Presenca> findAll();
	public Presenca findById(Long id);
	
	@Query("select p.aluno from Presenca p where  p.disciplina.id=?1 ")
	public List<Aluno> findAlunosByDisciplina(Long id);

}
