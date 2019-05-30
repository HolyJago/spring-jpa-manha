package br.com.gustavozancheta.springjpamanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	List<Usuario> findByNomeDoUsuarioContaining(String nome);
	
	List<Usuario> findByEmailEndingWith(String sufixo);
	
	//Vai gerar:
	//SELECT * FROM public.usuario WHERE nome ILIKE '%parametro%' ESCAPE '\'
	
}
