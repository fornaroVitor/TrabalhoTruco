package TRABALHO;

import java.util.*;

class Carta {
    String valor;
    String naipe;

    Carta(String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }
}

class Baralho {
    List<Carta> cartas = new ArrayList<>();

    Baralho() {
        String[] valores = {"A","2","3","4","5","6","7","Q","J","K"};
        String[] naipes = {"ouro","copas","espadas","paus"};

        for(String naipe : naipes) {
            for(String valor : valores) {
                cartas.add(new Carta(valor, naipe));
            }
        }
    }

    void embaralhar() {
        Collections.shuffle(cartas);
    }
}

class Jogador {
    List<Carta> mao = new ArrayList<>();
    int pontuacao;

    void receberCarta(Carta carta) {
        mao.add(carta);
    }

    Carta jogarCarta() {
        return mao.remove(0); // joga a primeira carta
    }
}

class Jogo {
    Baralho baralho = new Baralho();
    Jogador jogador1 = new Jogador();
    Jogador jogador2 = new Jogador();
    Jogador jogador3 = new Jogador();
    Jogador jogador4 = new Jogador();

    void distribuirCartas() {
        baralho.embaralhar();
        for(int i = 0; i < 3; i++) {
            jogador1.receberCarta(baralho.cartas.remove(0));
            jogador2.receberCarta(baralho.cartas.remove(0));
            jogador3.receberCarta(baralho.cartas.remove(0));
            jogador4.receberCarta(baralho.cartas.remove(0));
        }
    }

    void jogarRodada() {
        System.out.println("Rodada iniciada!");
        Carta vira = baralho.cartas.remove(0);
        System.out.println("A carta 'vira' é: " + vira);

        Carta cartaJogador1 = jogador1.jogarCarta();
        System.out.println("Equipe 1:Jogador 1 jogou: " + cartaJogador1);
        Carta cartaJogador2 = jogador2.jogarCarta();
        System.out.println("Equipe 2:Jogador 2 jogou: " + cartaJogador2);
        Carta cartaJogador3 = jogador3.jogarCarta();
        System.out.println("Equipe 1:Jogador 3 jogou: " + cartaJogador3);
        Carta cartaJogador4 = jogador4.jogarCarta();
        System.out.println("Equipe 2:Jogador 4 jogou: " + cartaJogador4);

        // Adicionando a lógica para determinar o vencedor da rodada
        String[] valores = {"2", "3", "4", "5", "6", "7", "Q", "J", "K", "A"};
        List<String> ordemValores = Arrays.asList(valores);

        int valorJogador1 = ordemValores.indexOf(cartaJogador1.valor);
        int valorJogador2 = ordemValores.indexOf(cartaJogador2.valor);
        int valorJogador3 = ordemValores.indexOf(cartaJogador3.valor);
        int valorJogador4 = ordemValores.indexOf(cartaJogador4.valor);

        int maiorValor = Math.max(Math.max(valorJogador1, valorJogador2), Math.max(valorJogador3, valorJogador4));

        if (maiorValor == valorJogador1) {
            System.out.println("Equipe 1 venceu a rodada!");
        } else if (maiorValor == valorJogador2) {
            System.out.println("Equipe 2 venceu a rodada!");
        } else if (maiorValor == valorJogador3) {
            System.out.println("Equipe 1 venceu a rodada!");
        } else {
            System.out.println("Equipe 2 venceu a rodada!");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        // Distribuir cartas para os jogadores
        jogo.distribuirCartas();

        // Jogar uma rodada
        jogo.jogarRodada();
    }
}