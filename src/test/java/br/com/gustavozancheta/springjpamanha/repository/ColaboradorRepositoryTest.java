package br.com.gustavozancheta.springjpamanha.repository;

import java.time.LocalDate;
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
public class ColaboradorRepositoryTest {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	//3) Selecione todos os colaboradores que ainda não estão alocados em setores.
	
	@Test
	@Transactional
	public void colaboradorSemSetorTest() {
		List<String> colaboradores = colaboradorRepository.colab();
		System.out.println("Colaborador sem setor: " + colaboradores);
		Assertions.assertThat(colaboradores.size()).isGreaterThan(0);
	}
	
	//4) Selecione a data de admissão mais antiga de um colaborador.
	
	@Test
	@Transactional
	public void colaboradorMaisAntigoTest() {
		LocalDate dataMaisAntiga = colaboradorRepository.dataMaisAntiga();
		System.out.println("Data Mais antiga: " + dataMaisAntiga);
		Assertions.assertThat(dataMaisAntiga);
	}
}
