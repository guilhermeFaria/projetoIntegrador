package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	public List<Aluno> findAll();
	public Aluno findById(Long id);
	@Query("from Aluno a where a.usuario.nome like %?1%")
	public List<Aluno> findByNome(String nome);

}
