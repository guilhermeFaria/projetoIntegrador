package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Aluno;

public interface ChamadaService {
	//public void fazerChamada();
	public boolean verificarPresenca(Long aluno, Long aula);
	public List<Aluno> getListaChamada(Long aula);
}
