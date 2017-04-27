package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.repository.DisciplinaRepository;

@Service("disciplinaService")
public class DisciplinaServiceImpl implements DisciplinaService {
	
	private DisciplinaRepository disciplinaRepo;

	public Disciplina buscar(Long id) {
		// TODO Auto-generated method stub
		return disciplinaRepo.findById(id);
	}

	public List<Disciplina> buscarTodos() {
		// TODO Auto-generated method stub
		return disciplinaRepo.findAll();
	}

	@Transactional
	public void salvar(Disciplina disciplina) {
		// TODO Auto-generated method stub
		disciplinaRepo.save(disciplina);

	}

}
