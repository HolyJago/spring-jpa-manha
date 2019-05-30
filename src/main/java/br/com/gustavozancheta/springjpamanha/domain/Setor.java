package br.com.gustavozancheta.springjpamanha.domain;

import java.util.List;

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
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setor_gem")
	@SequenceGenerator(name = "setor_gen", sequenceName = "setor_id_seq", allocationSize = -1)
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy = "setor")
	private List<Colaborador> colaboradores;
	
	@Override
	public String toString() {
		return String.format("Setor: %s", nome);
	}
}
