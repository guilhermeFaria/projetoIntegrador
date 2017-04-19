package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.repository.ProfessorRepository;

@Service("professorService")
public class ProfessorServicoImpl implements ProfessorService{
	
	@Autowired
	private ProfessorRepository professorRepository; 

	public void setProfRepo(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@Transactional
	public Professor cadastrarProfessores(Professor prof) {
		return professorRepository.save(prof);
		
	}

	public Professor buscar(Long id) {
		// TODO Auto-generated method stub
		return professorRepository.findById(id);
	}

	public List<Professor> buscarTodos() {
		// TODO Auto-generated method stub
		return professorRepository.findAll();
	}

	public List<Professor> buscar(String nome) {
		return professorRepository.searchByNome(nome);
	}
	
	
	

}
