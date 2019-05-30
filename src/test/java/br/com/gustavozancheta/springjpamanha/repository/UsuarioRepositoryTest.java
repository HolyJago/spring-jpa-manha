package br.com.gustavozancheta.springjpamanha.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gustavozancheta.springjpamanha.domain.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Test
	public void insertTests() {
		Usuario usuario = new Usuario();
		
		usuario.setEmail("teste@mail.com");
		usuario.setNomeDoUsuario("juquinha");
		usuario.setSobrenome("sobrenominho");
		
		usuarioRepository.save(usuario);
		
		List<Usuario> usuarios = usuarioRepository.findByNomeDoUsuarioContaining(usuario.getNomeDoUsuario());
		
		Assertions.assertThat(usuarios.size()).isEqualTo(1);
	}
	
	@Test
	public void insertUsuariosTests() {
		Usuario usuario = new Usuario();
		
		usuario.setEmail("teste@mail.com");
		usuario.setNomeDoUsuario("juquinha");
		usuario.setSobrenome("sobrenominho");
		
		usuarioRepository.save(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("trump@mail.com");
		usuario2.setNomeDoUsuario("trump");
		usuario2.setSobrenome("make america great again");
		
		usuarioRepository.save(usuario2);
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		Assertions.assertThat(usuarios.size()).isEqualTo(2);
	}
	
	@Test
	public void emailTest() {
		Usuario usuario = new Usuario();
		
		usuario.setEmail("teste@hotmail.com");
		usuario.setNomeDoUsuario("juquinha");
		usuario.setSobrenome("sobrenominho");
		
		usuarioRepository.save(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setEmail("trump@gmail.com");
		usuario2.setNomeDoUsuario("trump");
		usuario2.setSobrenome("make america great again");
		
		usuarioRepository.save(usuario2);
		
		List<Usuario> usuarios = usuarioRepository.findByEmailEndingWith("@hotmail.com");
		
		Assertions.assertThat(usuarios.size()).isEqualTo(1);
		Assertions.assertThat(usuarios.get(0).getNomeDoUsuario()).isEqualTo("juquinha");
	}
	
	@After
	public void tearDown() {
		usuarioRepository.deleteAll();
	}
}
