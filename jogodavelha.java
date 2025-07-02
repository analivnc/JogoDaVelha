import java.util.Scanner;

public class jogodavelha {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         boolean jogarNovamente = true;

         while (jogarNovamente){
            char[][] tabuleiro = new char[3][3];
            char jogadorAtual = 'X';
            boolean jogoAtivo = true;
            int rodada = 1;
         
        
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                 tabuleiro[i][j] = ' ';

        while (jogoAtivo){
            System.out.println("Rodada " + rodada);
           System.out.println("É a vez do jogador " + jogadorAtual == 'X');

        int linha, coluna;
            while (true){
            System.out.println("linha (0 - 2): ");
            linha = sc.nextInt();
            System.out.println("coluna (0 - 2): ");
            coluna = sc.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                 System.out.println("Posição inválida! Tente novamente.");
            } else if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Posição já ocupada! Tente outra.");
            } else {
                        break; 
                    }
            public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
              for (int i = 0; j < 3; j++)
              if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) ||
                ((tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) {
            return true;
        }


                 }
            }

        }

         }
    }
}
}
            
        
    



        



        