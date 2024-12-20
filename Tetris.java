package src.tetris;

//package src.tetris;

import java.util.ArrayList;
import java.util.Random;

// Classe principal do jogo
public class Tetris 
{
    public static void main(String[] args) 
    {
        // Criando uma matriz do jogo
        Matriz tela = new Matriz(60, 30);
        tela.criarTela();
    
        // Criando uma lista de blocos 
        BlocoGenerico[] blocos = 
        {
            new BlocoI(),
            new BlocoO(),
            new BlocoT(),
            new BlocoL(),
            new BlocoJ(),
            new BlocoS(),
            new BlocoZ()
        };
    
        // Lista para armazenar os formatos dos blocos
        ArrayList<char[][]> listaDeBlocos = new ArrayList<>();
    
        // Adicionando os formatos dos blocos à lista
        for (BlocoGenerico bloco : blocos) 
        {
            listaDeBlocos.add(bloco.formato());
        }
        
        Random random = new Random();

        int indiceSorteado = random.nextInt(listaDeBlocos.size()); 

        char[][] blocoSorteado = listaDeBlocos.get(indiceSorteado);

        tela.adicionarBloco(blocoSorteado, 27, 0);    

        tela.imprimirTela();     

        
    }
}
