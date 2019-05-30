package br.com.gustavozancheta.springjpamanha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

	@Query("SELECT s.nome FROM Setor s LEFT JOIN Colaborador c ON (s.id = c.setor) WHERE c.setor IS NULL")
	List<String> setorSemColab();
}
