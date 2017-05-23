package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Presenca;

public interface PresencaRepository extends CrudRepository<Presenca, Long>{
	public List<Presenca> findAll();
	public Presenca findById(Long id);

}
