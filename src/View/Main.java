package View;

import Biblioteca.ListaObject.Lista;
import Controller.PlayerController;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Lista lista= new Lista();

        PlayerController playerController= new PlayerController();

        playerController.adicionaMusica(lista, "T.N.T;AC/DC;3:34");
        playerController.adicionaMusica(lista, "Highway to Hell;AC/DC;3:28");
        playerController.adicionaMusica(lista, "Life Will Change;Shoji Meguro;4:22");
        playerController.adicionaMusica(lista, "Love is Show;Masayuki Suzuki;4:10");

        int opc= 0;
        while (opc != 9){
            opc= Integer.parseInt(JOptionPane.showInputDialog("Menu \n 1 - Adicionar música a Playlist \n 2 - Remover música da Playlist \n 3 - Reproduzir Playlist \n 9 - Sair"));
            switch (opc){
                case 1: playerController.adicionaMusica(lista, JOptionPane.showInputDialog("Digite dessa forma: Nome;Artista;Duração"));
                break;
                case 2:
                    try {
                        playerController.removeMusica(lista, Integer.parseInt(JOptionPane.showInputDialog("Digite a posição da música")) - 1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                break;
                case 3:
                    try {
                        playerController.executaPlaylist(lista);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                break;
                case 9: break;
            }
        }

    }
}
