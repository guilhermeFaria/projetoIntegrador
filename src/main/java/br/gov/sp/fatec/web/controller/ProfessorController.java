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

import br.gov.sp.fatec.model.Professor;
import br.gov.sp.fatec.service.ProfessorService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/presenca")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value = "/getById")
	public ResponseEntity<Professor> get(@RequestParam(value="id",defaultValue="1") Long id){
		Professor professor = professorService.buscar(id);
		if(professor == null){
			return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Professor>(professor,HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Professor>> getAll(){
		return new ResponseEntity<Collection<Professor>>(professorService.buscarTodos(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Professor save(@RequestBody Professor professor, HttpServletRequest request, HttpServletResponse response) {
		professor = professorService.salvar(professor);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/professor/getById?id=" + professor.getId());
		return professor;
	}

}
