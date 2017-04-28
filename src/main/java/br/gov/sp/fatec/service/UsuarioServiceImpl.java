package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public Usuario buscar(String login, String senha) {
		// TODO Auto-generated method stub
		return usuarioRepo.findByLogin(login, senha);
	}

	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuarioRepo.findAll();
	}

	@Transactional
	public Usuario salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepo.save(usuario);
		
	}
	

}
