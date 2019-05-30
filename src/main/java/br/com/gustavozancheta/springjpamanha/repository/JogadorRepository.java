package br.com.gustavozancheta.springjpamanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{

}
