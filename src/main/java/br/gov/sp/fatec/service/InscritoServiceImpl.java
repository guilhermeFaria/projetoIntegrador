package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Inscrito;
import br.gov.sp.fatec.repository.InscritoRepository;

@Service("inscritoService")
public class InscritoServiceImpl implements InscritoService {
	
	private InscritoRepository inscritoRepo;

	public Inscrito buscar(Long id) {
		// TODO Auto-generated method stub
		return inscritoRepo.findById(id);
	}

	public List<Inscrito> buscarTodos() {
		// TODO Auto-generated method stub
		return inscritoRepo.findAll();
	}
	
	@Transactional
	public void salvar(Inscrito inscrito) {
		inscritoRepo.save(inscrito);
	}

}
