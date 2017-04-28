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

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.service.UsuarioService;
import br.gov.sp.fatec.view.View;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	
	
	/*@RequestMapping(value = "/getById")
	public ResponseEntity<Usuario> get(@RequestParam(value="id",defaultValue="1") Long id){
		Usuario usuario = usuarioService.buscar(id);
		if(usuario == null){
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
	
	}*/
	
	@RequestMapping(value = "/getAll")
	public ResponseEntity<Collection<Usuario>> getAll(){
		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscarTodos(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
		usuario = usuarioService.salvar(usuario);
		//response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
		//return usuario;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	public void login(@RequestParam(value = "login") String login, @RequestParam(value ="senha") String senha, HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = usuarioService.buscar(login, senha);
		if(usuario !=null)
		{
			//Redireciona para pagina principal
		}
		else{
			//Redireciona para página de login
		}
		//response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
		//return usuario;
	}
}
