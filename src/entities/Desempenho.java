package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="desempenho", sequenceName="desempenho_seq", allocationSize=1)
@Inheritance(strategy=InheritanceType.JOINED)
public class Desempenho extends AbstractEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="desempenho")
	private Long id;
	
	@ManyToOne
	private Turma turma;
	
	@ManyToOne
	private Aluno aluno;
	
	@OneToMany(mappedBy="desempenho")
	private List<Nota> notas;

	
	
	//########################### METODOS ##############################################
	@Override
	public Long getId() {
		return id;
		
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	
	public void setNota(Nota nota){
		this.notas.add(nota);
	}
}
