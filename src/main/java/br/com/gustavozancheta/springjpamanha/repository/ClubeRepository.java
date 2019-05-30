package br.com.gustavozancheta.springjpamanha.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Clube;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Integer> {

	@Query("SELECT sum(c.quantidadeDeTitulosNacionais) FROM Clube c")
	BigDecimal somarQuantidadeDeTitulos();
	
}
