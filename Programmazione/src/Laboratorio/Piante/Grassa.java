package Laboratorio.Piante;

public class Grassa extends Pianta{
    private String nome;
    public Grassa(String nome, int giorniDiInnaffiare){
        super(giorniDiInnaffiare);
        if(nome == null || nome.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
    }
}
