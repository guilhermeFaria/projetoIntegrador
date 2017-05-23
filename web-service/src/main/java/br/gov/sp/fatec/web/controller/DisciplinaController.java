package br.gov.sp.fatec.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.service.DisciplinaService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/getById")
	public ResponseEntity<Disciplina> get(@RequestParam(value="id",defaultValue="1") Long id){
		Disciplina disciplina = disciplinaService.buscar(id);
		if(disciplina == null){
			return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Disciplina>(disciplina,HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Disciplina>> getAll(){
		return new ResponseEntity<Collection<Disciplina>>(disciplinaService.buscarTodos(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina save(@RequestBody Disciplina disciplina, HttpServletRequest request, HttpServletResponse response) {
		disciplina = disciplinaService.salvar(disciplina);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/disciplina/getById?id=" + disciplina.getId());
		return disciplina;
	}

}
