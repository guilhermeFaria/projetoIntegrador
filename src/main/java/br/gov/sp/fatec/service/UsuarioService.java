package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Usuario;

public interface UsuarioService {
	public Usuario buscar(String login, String senha);
	public List<Usuario> buscarTodos();
	public void salvar(Usuario usuario);

}
