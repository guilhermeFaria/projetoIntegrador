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
import br.gov.sp.fatec.model.ListaChamada;
import br.gov.sp.fatec.service.ChamadaService;
import br.gov.sp.fatec.view.View;


@RestController
@RequestMapping(value="/listaChamada")
public class ListaChamadaController {
	
	
	@Autowired
	private ChamadaService listaChamadaService;

	public void setChamadaService(ChamadaService listaChamadaService) {
		this.listaChamadaService = listaChamadaService;
	}
	
	
	
	
	@RequestMapping(value = "/getChamadaByAulaId")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Aluno>> get(@RequestParam(value = "id", defaultValue = "1") Long id){
		
		List<Aluno> alunos = listaChamadaService.getListaChamada(id);
		if(alunos == null){
			return new ResponseEntity<Collection<Aluno>>(alunos, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Aluno>>(alunos,HttpStatus.OK);
		
	}
	
	
	

}
