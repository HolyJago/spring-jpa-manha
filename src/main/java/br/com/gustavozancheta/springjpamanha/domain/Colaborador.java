package br.com.gustavozancheta.springjpamanha.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador_gem")
	@SequenceGenerator(name = "colaborador_gen", sequenceName = "colaborador_id_seq", allocationSize = -1)
	private Integer id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "setor_id", referencedColumnName = "id")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "gerente_id", referencedColumnName = "id")
	private Colaborador gerente;
	
	@Column(name = "hora_inicial")
	private LocalTime horaInicial;
	
	@Column(name = "hora_final")
	private LocalTime horaFinal;
	
	@Column(name = "data_admissao")
	private LocalDate dataAdmissao;
	
	private BigDecimal salario;
	
	private BigDecimal bonus;
	
	@OneToMany(mappedBy = "gerente")
	private List<Colaborador> colaboradores;
	
	@OneToMany(mappedBy = "colaborador")
	private List<Advertencia> advertenciaRecebida;
	
	@OneToMany(mappedBy = "gerente")
	private List<Advertencia> advertenciaFeita;
	
	@Override
	public String toString() {
		return String.format("Nome: %s", nome);
	}
}
