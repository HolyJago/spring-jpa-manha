package br.com.gustavozancheta.springjpamanha.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Clube {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clube_gen")
	@SequenceGenerator(name = "clube_gen", sequenceName = "clube_id_seq", allocationSize = -1)
	private Integer id;
	
	private String nome;
	
	@Column(name = "quantidade_titulos_nacionais")
	private Integer quantidadeDeTitulosNacionais;
	
	@OneToMany(mappedBy = "clube") // x:N -> LAZY
	private List<Jogador> jogadores;
	
	@Override
	public String toString() {
		return String.format("%s. Títulos: %d", nome, quantidadeDeTitulosNacionais);
	}
}
