package br.gov.sp.fatec.web.controller;

import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.service.AlunoService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value="/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@RequestMapping(value = "/get/{nome}")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Aluno>> pesquisar(@PathVariable("nome") String nome){
		
		return new ResponseEntity<Collection<Aluno>>(alunoService.buscarPorNome(nome),HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Aluno> get(@RequestParam(value = "id", defaultValue = "1") Long id){
		
		Aluno aluno = alunoService.buscar(id);
		if(aluno == null){
			return new ResponseEntity<Aluno>(aluno, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aluno>(aluno,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Aluno>> getAll(){
		return new ResponseEntity<Collection<Aluno>>(alunoService.buscarTodosAlunos(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno save(@RequestBody Aluno aluno, HttpServletRequest request, HttpServletResponse response){
		aluno = alunoService.cadastrarAlunos(aluno);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/aluno/getById?id=" + aluno.getId());
		
		return aluno;
	}

}
