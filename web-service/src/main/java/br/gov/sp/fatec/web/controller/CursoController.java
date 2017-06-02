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

import br.gov.sp.fatec.model.Curso;
import br.gov.sp.fatec.service.CursoService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	
	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Curso> get(@PathVariable(value="id") Long id){
		Curso curso = cursoService.buscar(id);
		if(curso == null){
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Curso>(curso,HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/list")
	public ResponseEntity<Collection<Curso>> getAll(){
		return new ResponseEntity<Collection<Curso>>(cursoService.buscarTodos(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Curso save(@RequestBody Curso curso, HttpServletRequest request, HttpServletResponse response) {
		curso = cursoService.salvar(curso);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/curso/getById?id=" + curso.getId());
		return curso;
	}

}
