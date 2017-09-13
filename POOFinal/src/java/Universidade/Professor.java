package Universidade;

import Exception.ProfessorInvalidoException;
import Externo.Grade;
import Externo.Pessoa;
import Externo.PossuiGrade;
import Exception.TamanhoInvalidoArrayException;
import java.util.ArrayList;

public class Professor extends Pessoa implements PossuiGrade{
    public static ArrayList<Professor> professores = new ArrayList<Professor>();
    private Grade horario;
    private String formacao;
    private int siape;
    public Professor(String nome, String cpf, char sexo) {
        super(nome, cpf, sexo);
    }

    public Professor(String formacao, int siape, String nome, String cpf, char sexo) throws TamanhoInvalidoArrayException, ProfessorInvalidoException{
        super(nome, cpf, sexo);
        if(formacao == null || siape < 0){
            throw new ProfessorInvalidoException("Dados do professor estão inválidos!");
        }else{
            this.horario = new Grade<Turma>(horasDia,diasSemana);
            this.formacao = formacao;
            this.siape = siape;
            professores.add(this);
        }
    }

    public Grade getHorario() {
        return horario;
    }

    public void setHorario(Grade horario) {
        this.horario = horario;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    @Override
    public boolean equals(PossuiGrade elemento) {
        if(elemento instanceof Professor){
            Professor p = (Professor)elemento;
            return p.getSiape() == this.getSiape() && p.getNome().equals(this.getNome());
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
}
