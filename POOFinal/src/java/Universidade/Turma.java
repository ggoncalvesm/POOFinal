package Universidade;

import Externo.Grade;
import Externo.PossuiGrade;
import Exception.TurmaInvalidaException;
import Exception.TamanhoInvalidoArrayException;
import FalsaDao.TurmaDAO;
import java.util.ArrayList;
import java.util.Random;

public class Turma implements PossuiGrade{
    
    private String nome;
    private int id;
    private ArrayList<Aluno> alunosMatriculados = new ArrayList<Aluno>();
    private Professor docente;
    private Grade horario;
    private ArrayList<Monitor> monitores = new ArrayList<Monitor>();
    private int limiteAlunos;
    private int aulasSemanais;

    public Turma(String nome, int id, Professor docente, int limiteAlunos, int aulasSemanais) throws TamanhoInvalidoArrayException, TurmaInvalidaException {
        this(docente, limiteAlunos, aulasSemanais);
        this.nome = nome;
        this.id = id;
    }

    
    public Turma(Professor docente, int limiteAlunos, int aulasSemanais) throws TamanhoInvalidoArrayException, TurmaInvalidaException{
        if(docente == null || limiteAlunos <= 0 || aulasSemanais <= 0){
            throw new TurmaInvalidaException("Dados do professor estão inválidos!");
        }else{
            this.horario = new Grade<Professor>(horasDia, diasSemana);
            this.docente = docente;
            this.limiteAlunos = limiteAlunos;
            this.aulasSemanais = aulasSemanais;
            TurmaDAO banco = new TurmaDAO();
            banco.adiciona(this);
        }
    }

    public int getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(int aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
    }
    
    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(ArrayList<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public Professor getDocente() {
        return docente;
    }

    public void setDocente(Professor docente) {
        this.docente = docente;
    }

    public Grade getHorario() {
        return horario;
    }

    public void setHorarios(Grade horario) {
        this.horario = horario;
    }

    public ArrayList<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(ArrayList<Monitor> monitores) {
        this.monitores = monitores;
    }

    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    public void setLimiteAlunos(int limiteAlunos) {
        this.limiteAlunos = limiteAlunos;
    }
    
    public boolean adicionaMonitor(Monitor monitor){
        return monitores.add(monitor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean alocaHorario(){
        if(!alocaHorarioInterface()){
            horario.removeTodos(docente);
            return false;
        }
        return true;
    }
    
    private boolean alocaHorarioInterface(){
        int aulas = aulasSemanais;
        int linha = 0, coluna = 0, voltas = 0;
        Random random = new Random();
        while(aulas > 0){
            if(voltas >= 1000){
                System.out.println("Entrei aqui");
                return false;
            }
            linha = random.nextInt(horasDia);
            coluna = random.nextInt(diasSemana);
            if(horario.verifica(linha, coluna) == null && docente.getHorario().verifica(linha, coluna) == null){
                docente.getHorario().altera(linha, coluna, this);
                horario.altera(linha, coluna, docente);
                aulas--;
                if(horario.verifica(linha, (coluna+2)%diasSemana) == null && docente.getHorario().verifica(linha, (coluna+2)%diasSemana) == null && aulas > 0){
                    docente.getHorario().altera(linha, (coluna+2)%diasSemana, this);
                    horario.altera(linha, (coluna+2)%diasSemana, docente);
                    aulas--;
                }
            }
            voltas++;
        }
        return true;
    }
    
    @Override
    public boolean equals(PossuiGrade elemento) {
        if(elemento instanceof Turma){
            Turma t = (Turma)elemento;
            return t.getId() == this.getId() && t.getNome().equals(this.getNome());
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
}
