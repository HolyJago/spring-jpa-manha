package br.com.gustavozancheta.springjpamanha.domain;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class Advertencia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador_gem")
	@SequenceGenerator(name = "jogador_gen", sequenceName = "jogador_id_seq", allocationSize = -1)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER) // x:1 -> EAGER
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Colaborador colaborador;
	
	@ManyToOne(fetch = FetchType.EAGER) // x:1 -> EAGER
	@JoinColumn(name = "gerente_id", referencedColumnName = "id")
	private Colaborador gerente;
	
	private String descricao;
	
	@Column(name = "data_advertencia")
	private LocalDate dataAdvertencia;
}
