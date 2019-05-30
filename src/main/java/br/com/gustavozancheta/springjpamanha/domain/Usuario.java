package br.com.gustavozancheta.springjpamanha.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_id_seq", allocationSize = -1)
	private Integer id;
	
	@Column(name = "nome")
	private String nomeDoUsuario;
	
	private String email;
	
	//transient - ñ é coluna persistente, ñ existe na tabela
	@Transient
	private String sobrenome;
}
