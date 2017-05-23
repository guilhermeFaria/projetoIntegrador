package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.repository.ProfessorRepository;

@Service("professorService")
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorRepository profRepo;

	public Professor buscar(Long id) {
		// TODO Auto-generated method stub
		return profRepo.findById(id);
	}

	public List<Professor> buscarTodos() {
		// TODO Auto-generated method stub
		return profRepo.findAll();
	}

	@Transactional
	public Professor salvar(Professor professor) {
		// TODO Auto-generated method stub
		return profRepo.save(professor);
		
	}

}
