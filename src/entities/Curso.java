package entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="curso", sequenceName="curso_seq", allocationSize=1)
@Inheritance(strategy=InheritanceType.JOINED)
public class Curso extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="curso")
	private Long id;	
	private String nome;
	private String tipo;
	
	//@OneToMany(mappedBy="curso", fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@OneToMany
	private List<Aluno> alunos;
	
	@ManyToMany
	private List<Professor> professores;
	
	@OneToMany
	private List<Disciplina> disciplinas;
	
	
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void setProfessor(Professor professor){
		this.professores.add(professor);
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	

}
