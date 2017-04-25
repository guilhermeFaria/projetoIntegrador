package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Inscrito;

public interface InscritoRepository extends CrudRepository<Inscrito, Long>{
	
	public List<Inscrito> findAll();
	
	public Inscrito findById(Long id);
	

}
