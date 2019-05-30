package br.com.gustavozancheta.springjpamanha.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

	@Query("SELECT c.nome FROM Colaborador c LEFT JOIN Setor s ON (c.setor = s.id) WHERE c.setor IS NULL")
	List<String> colab();
	
	@Query("SELECT dataAdmissao from Colaborador ORDER BY dataAdmissao asc limit 1")
	LocalDate dataMaisAntiga();
}
