package Controller;

import Biblioteca.ListaObject.Lista;
import Model.Musica;

import java.io.IOException;

public class PlayerController {

    public PlayerController(){
        super();
    }


    public void adicionaMusica(Lista lista, String musica){
        String[] vet= musica.split(";");
        String[] duracao= vet[2].split(":");
        int minutos;
        int segundos;
        int tempo;

        minutos= Integer.parseInt(duracao[0]) * 60;
        segundos= Integer.parseInt(duracao[1]);
        tempo= minutos + segundos;
        if (lista.isEmpty()){
            lista.addFirst(new Musica(vet[0], vet[1], tempo));
        }
        else {
            try {
                lista.addLast(new Musica(vet[0], vet[1], tempo));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void removeMusica(Lista lista, int posicao) throws IOException {
        try {
            lista.remove(posicao);
        } catch (Exception e) {
            throw new IOException("Playlist Vazia!");
        }
    }

    public void executaPlaylist(Lista lista) throws IOException {
        int tamanho= lista.size();
        int cont= 0;
        if (lista.isEmpty()){
            throw new IOException("Playlist Vazia!");
        }
        while (cont < tamanho){
            try {
                Musica musica= (Musica) lista.get(cont);
                System.out.printf("[%s - %s - %ds]\n", musica.getNome(), musica.getNomeArtista(), musica.getDuracao());
                Thread.sleep(musica.getDuracao() * 1000L);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            cont++;
        }
    }

}
