import java.util.Scanner;

public class jogodavelha {

    public static void imprimirTabuleiro(char[][] tabuleiro) {
        limparTela();
        System.out.println();
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print("\t" + tabuleiro[linha][coluna]);
                if (coluna < 2) {
                    System.out.print("\t|");
                }
            }
            System.out.println();
            if (linha < 2) {
                System.out.println("\t-------------------------------------");
            }
        }
        System.out.println();
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar a tela");
        }
    }

    public static boolean verificarVitoria(char[][] t, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0] == jogador && t[i][1] == jogador && t[i][2] == jogador) return true; 
            if (t[0][i] == jogador && t[1][i] == jogador && t[2][i] == jogador) return true; 
        }
        if (t[0][0] == jogador && t[1][1] == jogador && t[2][2] == jogador) return true; 
        if (t[0][2] == jogador && t[1][1] == jogador && t[2][0] == jogador) return true; 
        return false;
    }

    public static boolean verificarEmpate(char[][] t) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matriz = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char jogadorAtual = 'X';
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            System.out.println("### JOGO DA VELHA ###");
            imprimirTabuleiro(matriz);

            System.out.println("Vez do jogador '" + jogadorAtual + "'");
            System.out.print("Informe a linha (0 a 2): ");
            int linha = scanner.nextInt();
            System.out.print("Informe a coluna (0 a 2): ");
            int coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || matriz[linha][coluna] != ' ') {
            System.out.println("Jogada inválida. Pressione ENTER para continuar...");
            scanner.nextLine(); 
            scanner.nextLine(); 
            continue;
            }

            matriz[linha][coluna] = jogadorAtual;

            if (verificarVitoria(matriz, jogadorAtual)) {
                imprimirTabuleiro(matriz);
                System.out.println("Parabéns! Jogador '" + jogadorAtual + "' venceu!");
                jogoAtivo = false;
            } else if (verificarEmpate(matriz)) {
                imprimirTabuleiro(matriz);
                System.out.println("Empate!");
                jogoAtivo = false;
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
        System.out.println("Fim de jogo!");
    }
}