package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Aula;
import br.gov.sp.fatec.model.ListaChamada;
import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.repository.AlunoRepository;
import br.gov.sp.fatec.repository.AulaRepository;
import br.gov.sp.fatec.repository.ListaChamadaRepository;
import br.gov.sp.fatec.repository.ProfessorRepository;

@Service("chamadaService")
public class ChamadaServiceImpl implements ChamadaService {
	@Autowired
	private ListaChamadaRepository listaChamadaRepo;
	
	@Autowired
	private AulaRepository aulaRepo;
	
	@Autowired
	private AlunoRepository alunoRepo;
	


	/*@Transactional
	public void fazerChamada() {
		List<Aluno> alunos = alunoRepo.findAll();
		Professor professor = professorRepo.searchByNome("Mineda");
		Aula aula = aulaRepo.findById(1l);
		
		for(Aluno aluno : alunos) {
			if(!aluno.getRa().equals("2424")) {
				ListaChamada lc = new ListaChamada();
				//lc.setProf(professor);
				lc.setAluno(aluno);
				lc.setAula(aula);
				
				listaChamadaRepo.save(lc);
			}
		}
	}*/
	
	@Transactional
	public boolean verificarPresenca(Long aluno, Long aula) {		
		if(listaChamadaRepo.findByAlunoAula(aluno, aula) != null){
			return true;
		}
		return false;
	}
	
	
	public void setListaChamadaRepo(ListaChamadaRepository listaChamadaRepo) {
		this.listaChamadaRepo = listaChamadaRepo;
	}

	public void setAulaRepo(AulaRepository aulaRepo) {
		this.aulaRepo = aulaRepo;
	}

	public void setAlunoRepo(AlunoRepository alunoRepo) {
		this.alunoRepo = alunoRepo;
	}


	public List<Aluno> getListaChamada(Long aula) {
		
		return listaChamadaRepo.searchAlunosByAulaId(aula);
	}

}
