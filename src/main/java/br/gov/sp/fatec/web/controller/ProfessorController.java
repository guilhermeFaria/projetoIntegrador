package br.gov.sp.fatec.web.controller;

import java.util.Collection;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.service.ProfessorService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value="/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService profService;

	public void setProfessorService(ProfessorService profService) {
		this.profService = profService;
	}
	
	@RequestMapping(value = "/get/{nome}")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Professor>> pesquisar(@PathVariable("nome") String nome){
		
		return new ResponseEntity<Collection<Professor>>(profService.buscar(nome),HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Professor> get(@RequestParam(value = "id", defaultValue = "1") Long id){
		
		Professor prof = profService.buscar(id);
		if(prof == null){
			return new ResponseEntity<Professor>(prof, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Professor>(prof,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Professor>> getAll(){
		return new ResponseEntity<Collection<Professor>>(profService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Professor save(@RequestBody Professor prof, HttpServletRequest request, HttpServletResponse response){
		prof = profService.cadastrarProfessores(prof);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/prof/getById?id=" + prof.getId());
		
		return prof;
	}

}
