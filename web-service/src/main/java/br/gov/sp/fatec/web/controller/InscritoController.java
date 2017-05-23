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

import br.gov.sp.fatec.model.Inscrito;
import br.gov.sp.fatec.service.InscritoService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/inscrito")
public class InscritoController {
	
	@Autowired
	private InscritoService inscritoService;
	
	@RequestMapping(value = "/getById")
	public ResponseEntity<Inscrito> get(@RequestParam(value="id",defaultValue="1") Long id){
		Inscrito inscrito = inscritoService.buscar(id);
		if(inscrito == null){
			return new ResponseEntity<Inscrito>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inscrito>(inscrito,HttpStatus.OK);
	
	}
	
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Inscrito>> getAll(){
		return new ResponseEntity<Collection<Inscrito>>(inscritoService.buscarTodos(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public Inscrito save(@RequestBody Inscrito inscrito, HttpServletRequest request, HttpServletResponse response) {
		inscrito = inscritoService.salvar(inscrito);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/inscrito/getById?id=" + inscrito.getId());
		return inscrito;
	}

}
