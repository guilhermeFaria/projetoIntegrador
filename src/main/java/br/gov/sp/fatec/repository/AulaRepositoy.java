package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Aula;

public interface AulaRepositoy extends CrudRepository<Aula, Long> {
	
	public List<Aula> findAll();
	public Aula findById(Long id);

}
