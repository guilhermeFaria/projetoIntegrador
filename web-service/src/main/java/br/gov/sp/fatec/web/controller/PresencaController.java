package br.gov.sp.fatec.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Presenca;
import br.gov.sp.fatec.service.PresencaService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/presenca")
public class PresencaController {
	
	@Autowired
	private PresencaService presencaService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROF')")
	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Presenca> get(@PathVariable(value="id") Long id){
		Presenca presenca = presencaService.buscar(id);
		if(presenca == null) {
			return new ResponseEntity<Presenca>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<Presenca>(presenca,HttpStatus.OK);
	
	}
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROF')")
	@RequestMapping(value = "/get/{disciplina}/{data}")
	public ResponseEntity<Collection<Presenca>> getAll(@PathVariable(value="disciplina") Long disciplina, @PathVariable(value="data") Long dataMS){
		Date data = new Date(dataMS);
		return new ResponseEntity<Collection<Presenca>>(presencaService.buscarTodos(disciplina, data),HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROF')")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public List<Presenca> save(@RequestBody List<Presenca> presencas, HttpServletRequest request, HttpServletResponse response) {
		for(Presenca p:presencas){
			presencaService.salvar(p);
		}
		//response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/presenca/getById?id=" + presenca.getId());
		return presencas;
	}
	
	@PreAuthorize("hasRole('ROLE_PROF')")
	@RequestMapping(value = "/get/alunos/{id}")
	public ResponseEntity<Collection<Aluno>> getAlunos(@PathVariable(value="id") Long id){
		List<Aluno> alunos = presencaService.buscarPorDisciplina(id);
		if(alunos == null){
			return new ResponseEntity<Collection<Aluno>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Aluno>>(alunos,HttpStatus.OK);
	
	}
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(value = "/get/disciplinas/{idAluno}")
	public ResponseEntity<Collection<Disciplina>> getDisciplinas(@PathVariable(value="idAluno") Long idAluno){
		List<Disciplina> disciplinas = presencaService.buscarDisciplinaPorAluno(idAluno);
		if(disciplinas == null){
			return new ResponseEntity<Collection<Disciplina>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Disciplina>>(disciplinas,HttpStatus.OK);
	
	}
	
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(value = "/get/faltas/{idAluno}/{idDisciplina}")
	public ResponseEntity<Long> getFaltas(@PathVariable(value="idAlunno") Long idAluno,@PathVariable(value="idDisciplina")Long idDisciplina){
		Long faltas = presencaService.qtdePresencaFalta(idAluno, idDisciplina, false);
		if(faltas == null){
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(faltas,HttpStatus.OK);
	
	}
	
	@PreAuthorize("hasRole('ROLE_ALUNO')")
	@RequestMapping(value = "/get/presente/{idAluno}/{idDisciplina}")
	public ResponseEntity<Long> getPresencas(@PathVariable(value="idAlunno") Long idAluno,@PathVariable(value="idDisciplina")Long idDisciplina){
		Long presencas = presencaService.qtdePresencaFalta(idAluno, idDisciplina, true);
		if(presencas == null){
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(presencas,HttpStatus.OK);
	
	}


}
