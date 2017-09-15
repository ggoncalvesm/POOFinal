package FalsaDao;

import Exception.ProfessorInvalidoException;
import Exception.TamanhoInvalidoArrayException;
import Universidade.Professor;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO {
    private static ArrayList<Professor> professores = new ArrayList<Professor>();

    static{
        try {
            professores.add(new Professor("Eng. de Software", 10, "Gabriel", "12344556756", 'M'));
        } catch (TamanhoInvalidoArrayException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProfessorInvalidoException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Professor consulta(String nome){
        for(Professor professor : professores){
            if(professor.getNome().equals(nome)){
                return professor;
            }
        }
        return null;
    }
    
    public boolean adiciona(Professor professor){
        return professores.add(professor);
    }
    
    public int qntElementos(){
        return professores.size();
    }
    
    public Professor consulta(int index) throws IndexOutOfBoundsException{
        return professores.get(index);
    }
}
