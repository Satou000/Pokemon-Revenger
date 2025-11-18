package historia.capitulos;
import historia.Capitulo;
import historia.ResultadoCapitulo;
import java.util.Scanner;
import personagem.Jogador;
import util.Util;

/**
 * Implementa a lógica do Capítulo 2.
 */
public class CapituloDois implements Capitulo {

    @Override
    public ResultadoCapitulo executar(Jogador jogador, Scanner scanner) {
        System.out.println("\n--- CAPÍTULO 2: A GAIOLA ---");
        
        // Força o HP do jogador para 1
        jogador.setHp(1);
        System.out.println("\n(A tela está preta.) ...dor... ...frio...");
        System.out.println("A dor é a primeira coisa que você sente. (HP: " + jogador.getHp() + "/" + jogador.getHpMax() + " [PERIGO])");
        System.out.println("Você força seus olhos a abrirem. Você está em uma gaiola de metal.");
        Util.pausar(2);

        System.out.println("O humano te vê. \"Ah, ótimo. A 'mercadoria' acordou.\"");
        System.out.println("Ele chuta sua gaiola. Ele te joga no chão de concreto.");
        System.out.println("Humano: \"Quil! Saia! Use Brasa.\"");
        System.out.println("O Quilava hesita, mas obedece. A chama é fraca, mas dói. (HP 01/" + jogador.getHpMax() + ")");
        Util.pausar(2);
        
        System.out.println("Humano: \"Patético. Nem vale a pena gastar uma Potion com você.\"");
        System.out.println("Ele te joga de volta na gaiola. \"Eu tenho... negócios... a tratar.\"");
        System.out.println("Você o ouve subir as escadas. Silêncio.");
        System.out.println("Você se encosta na porta da gaiola... e ela se move. A trava está solta.");
        Util.pausar(2);

        int escolha = Util.obterEscolha(scanner, "O QUE VOCÊ FAZ?",
            "[TENTAR FUGIR AGORA] (A dor é imensa, mas a chance é agora.)",
            "[ESPERAR E OBSERVAR] (Fugir agora, com 1 HP, é suicídio.)");

        if (escolha == 1) {
            // CAMINHO A: FUGIR (FINAL RUIM 1)
            System.out.println("\nVocê reúne o que resta de sua força. Você empurra o trinco.");
            System.out.println("Você se arrasta, uma pata de cada vez, até as escadas.");
            System.out.println("Você vê... a noite. Um beco sujo. É o cheiro da liberdade.");
            System.out.println("Você corre para a escuridão...");
            Util.pausar(3);
            
            // Retorna o resultado do Final Ruim
            String msgFinal = "[FINAL RUIM 1: O FUGITIVO]\n" +
                              "Você conseguiu. Você está livre. Você encontrou Oran Berries e se curou.\n" +
                              "Mas... não é o mesmo. Você nunca encontrou o Sentret.\n" +
                              "Você se assusta com cada som. Você vive com medo.\n" +
                              "Um dia, você vê outro treinador capturando um Poliwag do seu riacho.\n" +
                              "Você fica assistindo, tremendo, incapaz de ajudar.\n" +
                              "Você viveu. Mas sua casa se foi. Você se pergunta se sua fuga realmente mudou alguma coisa.";
            return ResultadoCapitulo.finalRuim(msgFinal);

        } else {
            // CAMINHO B: ESPERAR
            System.out.println("\nNão. Fugir agora é inútil. Você não chegará nem na porta.");
            System.out.println("O Quilava... ele não queria te machucar. O humano... recebia ordens?");
            System.out.println("Você se encolhe no canto. A exaustão e a dor te vencem. Você desmaia.");
            Util.pausar(3);
            
            System.out.println("\n(Você acorda com o som da porta do porão se abrindo.)");
            // Recupera um pouco de HP
            jogador.setHp(5);
            System.out.println("(Seu corpo recuperou o mínimo de energia. HP: " + jogador.getHp() + "/" + jogador.getHpMax() + ")");
            System.out.println("Humano: \"Levanta. Temos um encontro. E tente não parecer tão patético.\"");

            // Bônus de EXP do Capítulo
            jogador.ganharExp(50);
            
            System.out.println("\n(Fim do Capítulo 2.)");
            return ResultadoCapitulo.continuar();
        }
    }
}