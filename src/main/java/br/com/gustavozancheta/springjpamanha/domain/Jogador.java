package br.com.gustavozancheta.springjpamanha.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador_gem")
	@SequenceGenerator(name = "jogador_gen", sequenceName = "jogador_id_seq", allocationSize = -1)
	private Integer id;
	
	private String nome;
	
	private Integer habilidade;
	
	@ManyToOne(fetch = FetchType.EAGER) // x:1 -> EAGER
	@JoinColumn(name = "clube_id", referencedColumnName = "id")
	private Clube clube;
	
	@Override
	public String toString() {
		return String.format("------> %s, Habilidade: %d", nome, habilidade);
	}
}
