package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Usuario;
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	@Query("from Usuario u where u.login=?1 and u.senha = ?2")
	public Usuario findByLogin(String login,String senha);

}
