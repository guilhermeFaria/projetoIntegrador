package br.gov.sp.fatec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Aula;
import br.gov.sp.fatec.model.ListaChamada;
import br.gov.sp.fatec.model.ListaChamadaID;
import br.gov.sp.fatec.model.Professor;

public interface ListaChamadaRepository extends CrudRepository<ListaChamada	, Long> {
	public List<ListaChamada> findAll();
	
	
	@Query("from ListaChamada lc where lc.listaChamadaId.aluno.id=?1 and lc.listaChamadaId.aula.id=?2")
	public ListaChamada findByAlunoAula(Long aluno, Long aula);
	
	@Query("select listaChamadaId.aluno from ListaChamada lc where lc.listaChamadaId.aula.id=?1")
	public List<Aluno> searchAlunosByAulaId(Long id);
	
	
	
	/*@Query("select aula from ListaChamada lc where lc.listaChamadaId.aula.id=?1")
	public Aula searchAulaById(Long id);*/

}
