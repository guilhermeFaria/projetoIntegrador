package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aula;
import br.gov.sp.fatec.repository.AulaRepositoy;

@Service("aulaService")
public class AulaServiceImpl implements AulaService{
	
	@Autowired
	private AulaRepositoy aulaRepo;

	public Aula buscar(Long id) {
		// TODO Auto-generated method stub
		return aulaRepo.findById(id);
	}

	public List<Aula> buscarTodos() {
		// TODO  Auto-generated method stub
		return aulaRepo.findAll();
	}

	@Transactional
	public Aula salvar(Aula aula) {
		return aulaRepo.save(aula);
	}

}
