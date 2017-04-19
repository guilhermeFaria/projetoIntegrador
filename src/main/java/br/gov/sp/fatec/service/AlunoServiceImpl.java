package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.repository.AlunoRepository;

@Service("alunoService")
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository alunoRepo; 
	

	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}

	@Transactional
	public Aluno cadastrarAlunos(Aluno aluno) {
		/*Aluno aluno1 = new Aluno();
		aluno1.setNome("Denis Campos de Paula");
		aluno1.setRa("7777");
		alunoRepo.save(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Cleiton Alves");
		aluno2.setRa("0000");
		alunoRepo.save(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("João Vitor");
		aluno3.setRa("2424");
		alunoRepo.save(aluno3);
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Igor Lima");
		aluno4.setRa("1212");
		alunoRepo.save(aluno4);
		
		Aluno aluno5 = new Aluno();
		aluno5.setNome("Gustavo Oliveira");
		aluno5.setRa("4444");
		alunoRepo.save(aluno5);*/
		
		alunoRepo.save(aluno);
		return aluno;
		
	}

	public Aluno buscar(Long id) {
		return alunoRepo.findById(id);
	}

	public List<Aluno> buscarTodosAlunos() {
		// TODO Auto-generated method stub
		return alunoRepo.findAll();
	}

	public List<Aluno> buscarPorNome(String nome) {
		
		return alunoRepo.searchByName(nome);
	}
	
	

}
