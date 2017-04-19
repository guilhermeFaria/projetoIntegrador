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

import br.gov.sp.fatec.model.Aula;
import br.gov.sp.fatec.service.AulaService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value="/aula")
public class AulaController {
	
	@Autowired
	private AulaService aulaService;

	public void setAulaService(AulaService aulaService) {
		this.aulaService = aulaService;
	}
	
	@RequestMapping(value = "/get/{nome}")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Aula>> pesquisar(@PathVariable("nome") String nome){
		
		return new ResponseEntity<Collection<Aula>>(aulaService.buscar(nome),HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value = "/getById")
	@JsonView(View.All.class)
	public ResponseEntity<Aula> get(@RequestParam(value = "id", defaultValue = "1") Long id){
		
		Aula aula = aulaService.buscar(id);
		if(aula == null){
			return new ResponseEntity<Aula>(aula, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Aula>(aula,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getAll")
	@JsonView(View.All.class)
	public ResponseEntity<Collection<Aula>> getAll(){
		return new ResponseEntity<Collection<Aula>>(aulaService.buscarAulas(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Aula save(@RequestBody Aula aula, HttpServletRequest request, HttpServletResponse response){
		aula = aulaService.cadastrarAula(aula);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/aula/getById?id=" + aula.getId());
		
		return aula;
	}

}
