package FalsaDao;

import Universidade.Turma;
import java.util.ArrayList;

public class TurmaDAO {
    private static ArrayList<Turma> turmas = new ArrayList<Turma>();
    public Turma consulta(String nome){
        for(Turma turma : turmas){
            if(turma.getNome().equals(nome)){
                return turma;
            }
        }
        return null;
    }
    
    public boolean adiciona(Turma turma){
        return turmas.add(turma);
    }
    
    public int qntElementos(){
        return turmas.size();
    }
    
    public Turma consulta(int index) throws IndexOutOfBoundsException{
        return turmas.get(index);
    }
}
