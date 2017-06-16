package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario{
	@Column(nullable=false)
	private String areaAtuacao;
	
	@Column(nullable=false)
	private String titulacao;
	
	@ManyToMany(mappedBy="professores", fetch=FetchType.LAZY) //, fetch=FetchType.LAZY
	private List<Curso> cursos;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Turma> turmas;
	
	
	
	//########################### METODOS ##############################################	
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
	
	public String getTitulacao() {
		return titulacao;
	}
	
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
