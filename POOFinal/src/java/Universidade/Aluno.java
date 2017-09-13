package Universidade;

import Externo.Pessoa;

public class Aluno extends Pessoa{
    private int matricula;
    private int qntTurmas = 0;
    private Curso curso;
    private int anoEntrada;

    public Aluno(int matricula, int qntTurmas, Curso curso, int anoEntrada, String nome, String cpf, char sexo) {
        super(nome, cpf, sexo);
        this.matricula = matricula;
        this.curso = curso;
        this.anoEntrada = anoEntrada;
    }
    
    public Aluno(String nome, String cpf, char sexo) {
        super(nome, cpf, sexo);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getQntTurmas() {
        return qntTurmas;
    }

    public void setQntTurmas(int qntTurmas) {
        this.qntTurmas = qntTurmas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        this.anoEntrada = anoEntrada;
    }
    
    
}
