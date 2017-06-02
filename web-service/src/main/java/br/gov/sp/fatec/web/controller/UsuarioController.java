package br.gov.sp.fatec.web.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.security.CriptografarSenha;
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
	
	@RequestMapping(value = "/list")
	public ResponseEntity<Collection<Usuario>> getAll(){
		return new ResponseEntity<Collection<Usuario>>(usuarioService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@JsonView(View.All.class)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String save(@RequestBody Usuario usuario, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		System.out.println("2");
		System.out.println(usuario.getSenha());
		String senhaCripto = CriptografarSenha.criptografar(usuario.getSenha());
		System.out.println("3");
		usuario.setSenha(senhaCripto);
		
		
		usuario = usuarioService.salvar(usuario);
		//response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/usuario/getById?id=" + usuario.getId());
		return "OKAY";
	}
	
	
}
