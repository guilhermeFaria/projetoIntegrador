package br.gov.sp.fatec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aula;
import br.gov.sp.fatec.repository.AulaRepository;

@Service("aulaService")
public class AulaServiceImpl implements AulaService {	
	@Autowired
	private AulaRepository aulaRepo;
	
	@Transactional
	public Aula cadastrarAula(Aula aula) {
		/*Date date = new Date();
		aula.setData(date);*/
		return aulaRepo.save(aula);
	}
	
	public void setAulaRepo(AulaRepository aulaRepo) {
		this.aulaRepo = aulaRepo;
	}

	public Aula buscar(Long id) {
		return aulaRepo.findById(id);
	}

	public List<Aula> buscarAulas() {
		return aulaRepo.findAll();
	}

	public List<Aula> buscar(String nome) {
		// TODO Auto-generated method stub
		return aulaRepo.findByNome(nome);
	}

	

}
