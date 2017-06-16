package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="disciplina", sequenceName="disciplina_seq", allocationSize=1)
@Inheritance(strategy=InheritanceType.JOINED)
public class Disciplina extends AbstractEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="disciplina")
	private Long id;
	private String nome;
	private String area;
	
	@ManyToOne
	private Curso curso;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Turma> turmas;
	
	
	
	//########################### METODOS ##############################################
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
}
