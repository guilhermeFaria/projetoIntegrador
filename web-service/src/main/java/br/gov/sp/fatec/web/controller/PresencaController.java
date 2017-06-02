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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Presenca;
import br.gov.sp.fatec.service.PresencaService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/presenca")
public class PresencaController {
	
	@Autowired
	private PresencaService presencaService;
	
	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Presenca> get(@PathVariable(value="id") Long id){
		Presenca presenca = presencaService.buscar(id);
		if(presenca == null) {
			return new ResponseEntity<Presenca>(HttpStatus.NOT_FOUND);
			

		}
		System.out.println("ola4");
		return new ResponseEntity<Presenca>(presenca,HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/list/{disciplina}/{data}")
	public ResponseEntity<Collection<Presenca>> getAll(@PathVariable(value="disciplina") Long disciplina, @PathVariable(value="data") Date data){
		return new ResponseEntity<Collection<Presenca>>(presencaService.buscarTodos(disciplina, data),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Presenca save(@RequestBody Presenca presenca, HttpServletRequest request, HttpServletResponse response) {
		presenca = presencaService.salvar(presenca);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/presenca/getById?id=" + presenca.getId());
		return presenca;
	}
	
	
	@RequestMapping(value = "/get/alunos/{id}")
	public ResponseEntity<Collection<Aluno>> getAlunos(@PathVariable(value="id") Long id){
		List<Aluno> alunos = presencaService.buscarPorDisciplina(id);
		if(alunos == null){
			return new ResponseEntity<Collection<Aluno>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Aluno>>(alunos,HttpStatus.OK);
	
	}


}
