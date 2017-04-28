package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.AlunoRepository;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepo;

	public Aluno buscar(Long id) {
		// TODO Auto-generated method stub
		return alunoRepo.findById(id);
	}

	public List<Aluno> buscar(String nome) {
		// TODO Auto-generated method stub
		return alunoRepo.findByNome(nome);
	}

	public List<Aluno> buscarTodos() {
		// TODO Auto-generated method stub
		return alunoRepo.findAll();
	}
	

	@Transactional
	public Aluno salvar(Aluno aluno) {
		return alunoRepo.save(aluno);

	}

}
