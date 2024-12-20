package src.tetris;

public abstract class BlocoGenerico 
{   
    public abstract char[][] formato(); 

    public char[][] rotacionar(char[][] formato) 
    {
        int numLinhas = formato.length;
        int numColunas = formato[0].length;
        char[][] formatoRotacionado = new char[numColunas][numLinhas];
        
        for (int i = 0; i < numLinhas; i++) 
        {
            for (int j = 0; j < numColunas; j++) 
            {
                formatoRotacionado[j][numLinhas - 1 - i] = formato[i][j];
            }
        }
        return formatoRotacionado;
    }
}

// Classe concreta para o bloco "I"
class BlocoI extends BlocoGenerico 
{
   
    @Override
    public char[][] formato() 
    {
        return new char[][]
        {
            {'#', '#', '#', '#'} 
        };
    }   
}

// Classe concreta para o bloco "O"
class BlocoO extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{'#', '#'}, {'#', '#'}};
        return N;       
    }
    
}


// Classe concreta para o bloco "T"
class BlocoT extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{' ', '#', ' '}, {'#', '#', '#'}};
        return N;
       
    }
}

// Classe concreta para o bloco "L"
class BlocoL extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{'#', ' ', ' '}, {'#', '#', '#'}};
        return N;
       
    }
}

// Classe concreta para o bloco "J"
class BlocoJ extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{' ', ' ', '#'}, {'#', '#', '#'}};
        return N;
       
    }
}

// Classe concreta para o bloco "S"
class BlocoS extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{' ', '#', '#'}, {'#', '#', ' '}};
        return N;
       
    }
}

// Classe concreta para o bloco "Z"
class BlocoZ extends BlocoGenerico 
{
    @Override
    public char[][] formato() 
    {
        char[][]  N = {{'#', '#', ' '}, {' ', '#', '#'}};
        return N;
       
    }
}