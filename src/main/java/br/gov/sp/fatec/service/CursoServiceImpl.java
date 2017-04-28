package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.repository.CursoRepository;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepo;

	public Curso buscar(Long id) {
		// TODO Auto-generated method stub
		return cursoRepo.findById(id);
	}

	public List<Curso> buscarTodos() {
		// TODO Auto-generated method stub
		return cursoRepo.findAll();
	}

	@Transactional
	public Curso salvar(Curso curso) {
		return cursoRepo.save(curso);

	}

}
