package br.com.gustavozancheta.springjpamanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gustavozancheta.springjpamanha.domain.Advertencia;

@Repository
public interface AdvertenciaRepository extends JpaRepository<Advertencia, Integer> {

}
