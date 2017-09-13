package Universidade;

public class Monitor extends Aluno{
    private String tipoBolsa;
    private float remuneracao;

    public Monitor(String tipoBolsa, float remuneracao, String nome, String cpf, char sexo) {
        super(nome, cpf, sexo);
        this.tipoBolsa = tipoBolsa;
        this.remuneracao = remuneracao;
    }
    
    public Monitor(String nome, String cpf, char sexo) {
        super(nome, cpf, sexo);
    }

    public String getTipoBolsa() {
        return tipoBolsa;
    }

    public void setTipoBolsa(String tipoBolsa) {
        this.tipoBolsa = tipoBolsa;
    }

    public float getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(float remuneracao) {
        this.remuneracao = remuneracao;
    }
    
}
