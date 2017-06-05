package br.gov.sp.fatec.service;

import java.util.Date;
import java.util.List;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Presenca;

public interface PresencaService {
	public Presenca buscar(Long id);
	public List<Presenca> buscarTodos(Long disciplina, Date data);
	public List<Aluno> buscarPorDisciplina(Long id);
	public List<Disciplina> buscarDisciplinaPorAluno(Long idAluno);
	public Long qtdePresencaFalta(Long idAluno,Long idDisciplina, boolean presenca);
	public Presenca salvar(Presenca presenca);

}
