package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Presenca;
import br.gov.sp.fatec.repository.PresencaRepository;

@Service("presencaService")
public class PresencaServiceImpl implements PresencaService {
	
	private PresencaRepository presencaRepo;

	public Presenca buscar(Long id) {
		// TODO Auto-generated method stub
		return presencaRepo.findById(id);
	}

	public List<Presenca> buscarTodos() {
		// TODO Auto-generated method stub
		return presencaRepo.findAll();
	}

	@Transactional
	public void salvar(Presenca presenca) {
		presencaRepo.save(presenca);

	}

}
