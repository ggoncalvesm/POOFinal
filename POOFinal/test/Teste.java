
import Exception.TamanhoInvalidoArrayException;
import Universidade.Professor;
import Universidade.Turma;
import Universidade.Monitor;

public class Teste {
    public static void main(String[] args){
        try{
            Professor p = new Professor("Ciência da Computação", 1212, "Marcos Vinicius", "01234567890", 'M');
            Turma t = new Turma("Programação Web", 151003, p, 50, 2);
            Turma t1 = new Turma("Projeto Detalhado de Software", 151003, p, 50, 2);
            Turma t2 = new Turma("Programação Orientada a Objetos", 151003, p, 50, 2);
            t.adicionaMonitor(new Monitor("Voluntário", (float)0.0, "Gabriel Moreira", "01234567890", 'M'));
           
            if(t.alocaHorario() && t1.alocaHorario() && t2.alocaHorario()){
                System.out.println(t.getHorario());
                System.out.println(t1.getHorario());
                System.out.println(t2.getHorario());
                System.out.println(p.getHorario());
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
