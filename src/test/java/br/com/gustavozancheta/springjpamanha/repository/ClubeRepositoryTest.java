package br.com.gustavozancheta.springjpamanha.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gustavozancheta.springjpamanha.domain.Clube;
import br.com.gustavozancheta.springjpamanha.domain.Jogador;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubeRepositoryTest {

	@Autowired
	private ClubeRepository clubeRepository;
	
	@Test
	@Transactional
	public void findAllTest() {
		List<Clube> clubes = clubeRepository.findAll();
		
		for (Clube clube : clubes) {
			System.out.println(clube);
			
			for (Jogador jogador : clube.getJogadores()) {
				System.out.println(jogador);
			}
		}
		
		Assertions.assertThat(clubes.size()).isEqualTo(3);
	}
	
	@Test
	public void somaQuantidadeDeTitulosTest() {
		BigDecimal quantidadeDeTitulos = clubeRepository.somarQuantidadeDeTitulos();
		Assertions.assertThat(quantidadeDeTitulos).isEqualTo(BigDecimal.valueOf(11));
	}
}
