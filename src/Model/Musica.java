package Model;

public class Musica {

    String nome;
    String nomeArtista;
    int duracao;

    public Musica(String nome, String nomeArtista, int duracao){
        this.nome= nome;
        this.nomeArtista= nomeArtista;
        this.duracao= duracao;
    }

    public String getNome(){
        return nome;
    }

    public String getNomeArtista(){
        return nomeArtista;
    }

    public int getDuracao(){
        return duracao;
    }

    @Override
    public String toString() {
        return this.nome +"-"+ this.nomeArtista +"-"+ this.duracao;
    }
}
