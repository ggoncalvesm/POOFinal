package Externo;

import Exception.TamanhoInvalidoArrayException;

public class Grade<I> {
    private I[][] elementos;

    public Grade(int linhas, int colunas) throws TamanhoInvalidoArrayException{
        if(linhas > 0 && colunas > 0){
            this.elementos = (I[][]) new Object[linhas][colunas];
        }else{
            throw new TamanhoInvalidoArrayException("Os valores informados para a grade são inválidos");
        }
    }
    
    public boolean altera(int linha, int coluna, I elemento){
        if(elementos.length > linha && elementos[0].length > coluna){
            elementos[linha][coluna] = elemento;
            return true;
        }
        return false;
    }
    
    public I verifica(int linha, int coluna){
        if(elementos.length > linha && elementos[0].length > coluna){
            return elementos[linha][coluna];
        }
        return null;
    }

    public void removeTodos(I elemento) {
        for(int l = 0;elementos.length > l; l++){
            for(int c = 0;elementos[0].length > c; c++){
                if(elemento.equals(elementos[l][c])){
                    altera(l, c, null);
                }
            }   
        }
    }
    
    @Override
    public String toString(){
        String formatada = "";
        for(int l = 0;elementos.length > l; l++){
            for(int c = 0;elementos[0].length > c; c++){
                if(verifica(l, c) == null){
                    formatada+="[ ]";
                }
                else{
                    formatada+="["+verifica(l, c).toString()+"]";
                }
            }
            formatada+="\n";
        }
        return formatada;
    }
    
}
