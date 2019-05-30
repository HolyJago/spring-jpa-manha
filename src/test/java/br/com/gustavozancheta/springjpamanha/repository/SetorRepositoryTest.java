package br.com.gustavozancheta.springjpamanha.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetorRepositoryTest {

	@Autowired
	private SetorRepository setorRepository;
	
	//1) Selecione todos os colaboradores mostrando seus respectivos setores.
//	@Test
//	@Transactional
//	public void findTest() {
//		List<Setor> setores = setorRepository.findAll();
//		for (Setor setor : setores) {
//			System.out.println(setor);
//			for (Colaborador colaborador : setor.getColaboradores()) {
//				System.out.println(colaborador);
//			}
//		}
//		Assertions.assertThat(setores.size()).isGreaterThan(0);
//	}
	
	//2) Selecione todos os setores que ainda não possuem colaboradores.
	@Test
	@Transactional
	public void SetorSemColaboradorTest() {
		List<String> setores = setorRepository.setorSemColab();
		System.out.println("Setor sem colaborador: " + setores);
		Assertions.assertThat(setores.size()).isGreaterThan(0);
	}

}
