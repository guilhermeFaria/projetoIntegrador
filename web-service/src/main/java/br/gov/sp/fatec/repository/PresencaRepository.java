package br.gov.sp.fatec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Presenca;

public interface PresencaRepository extends CrudRepository<Presenca, Long>{
	public List<Presenca> findAll();
	public Presenca findById(Long id);
	
	@Query("select p.aluno from Presenca p where  p.disciplina.id = ?1")
	public List<Aluno> findAlunosByDisciplina(Long id);
	
	@Query("select p.aluno from Presenca p where p.disciplina.id = ?1 and p.data = ?2")
	public List<Presenca> findAll(Long idDisciplina, Date data);
	
	@Query("select p.disciplina from Presenca p where p.aluno.id=?1")
	public List<Disciplina> findAllDisciplinaByAluno(Long idAluno);
	
	@Query("select count(*) from Presenca p where p.aluno.id=?1 and p.disciplina.id=?2 and p.presenca=?3")
	public Long countPresencasFaltas(Long idAluno,Long idDisciplina, boolean presenca);
	
}
