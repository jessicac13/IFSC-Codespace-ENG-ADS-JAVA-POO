package src.tetris;



public class Matriz 
{
    int largura;
    int altura;
    char[][] matriz;

    public Matriz(int largura, int altura) 
    {
        this.largura = largura;
        this.altura = altura;
        this.matriz = new char[altura][largura];
    }
    
    public void criarTela() 
    {
        for (int i = 0; i < altura; i++) 
        {
            for (int j = 0; j < largura; j++)
            {
                matriz[i][j] = '.'; 
            }
        }
    }

    public void imprimirTela() 
    {   
        limparTela();
        
        for (int i = 0; i < altura; i++) 
        {
            for (int j = 0; j < largura; j++) 
            {
                System.out.print(matriz[i][j]);
            }
            System.out.println(); 
        }
    }

    public void adicionarBloco(char[][] bloco, int x, int y) 
    {
        for (int i = 0; i < bloco.length; i++) 
        {
            for (int j = 0; j < bloco[i].length; j++) 
            {
                if (bloco[i][j] != '.')
                { 
                    matriz[y + i][x + j] = bloco[i][j];
                }
            }
        }
    }

    public boolean verificarColisao(char[][] bloco, int linha, int coluna) 
    {
        // Verifica se o bloco se encaixa na tela sem colidir
        for (int i = 0; i < bloco.length; i++) 
        {
            for (int j = 0; j < bloco[i].length; j++) 
            {
                if (bloco[i][j] != ' ') 
                {
                    int novaLinha = linha + i;
                    int novaColuna = coluna + j;

                    // Verifica limites da tela
                    if (novaLinha < 0 || novaLinha >= altura || novaColuna < 0 || novaColuna >= largura) 
                    {
                        return true; // Sai dos limites
                    }

                    // Verifica colisão com outro bloco
                    if (matriz[novaLinha][novaColuna] != '.') 
                    {
                        return true; // Colidiu com outro bloco
                    }
                }
            }
        }
        return false; // Não houve colisão
    }

    public void removerBloco(char[][] bloco, int linha, int coluna) 
    {
        for (int i = 0; i < bloco.length; i++) 
        {
            for (int j = 0; j < bloco[i].length; j++) 
            {
                if (bloco[i][j] != ' ') 
                {
                    matriz[linha + i][coluna + j] = ' ';
                }
            }
        }
    }

    public void limparTela()
    {
        // Limpa a tela do terminal (funciona em sistemas Unix e Windows)
        try 
        {
            // Para sistemas Unix ou Linux/macOS
            if (System.getProperty("os.name").toLowerCase().contains("nix") || 
                System.getProperty("os.name").toLowerCase().contains("nux") || 
                System.getProperty("os.name").toLowerCase().contains("mac")) 
            {
                // Limpa a tela
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } 
            else if (System.getProperty("os.name").toLowerCase().contains("win")) 
            {
                // Limpa a tela no Windows
                new ProcessBuilder("cmd", "/c", "cls", "clear").inheritIO().start().waitFor();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}