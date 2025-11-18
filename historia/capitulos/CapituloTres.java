package historia.capitulos;
import historia.Capitulo;
import historia.ResultadoCapitulo;
import java.util.Scanner;
import personagem.Inimigo;
import personagem.Jogador;
import util.Util;

/**
 * CRITÉRIO: Implementação de Interface
 * Implementa a lógica do Capítulo 3.
 */
public class CapituloTres implements Capitulo {

    @Override
    public ResultadoCapitulo executar(Jogador jogador, Scanner scanner) {
        System.out.println("\n--- CAPÍTULO 3: O PRÉDIO ABANDONADO ---");
        System.out.printf("(Status Atual: Nível %d. HP %d/%d. EXP %d/%d)\n", 
            jogador.getNivel(), jogador.getHp(), jogador.getHpMax(), jogador.getExp(), jogador.getExpParaProximoNivel());
        
        System.out.println("\nVocê está sendo carregado na gaiola. O humano está nervoso.");
        System.out.println("Ele te leva para um prédio abandonado.");
        System.out.println("Humano: \"Espere aqui. E fique quieto.\"");
        System.out.println("Ele te deixa no corredor e entra em uma sala. Você ouve vozes abafadas.");
        System.out.println("Você está sozinho. A trava da gaiola ainda está frouxa.");
        Util.pausar(2);

        int escolha = Util.obterEscolha(scanner, "O QUE VOCÊ FAZ?",
            "[TENTAR SAIR DA GAIOLA] (Você precisa saber o que está acontecendo.)",
            "[FICAR QUIETO] (É muito arriscado. É melhor esperar.)");

        if (escolha == 1) {
            // CAMINHO A: INVESTIGAR
            System.out.println("\nVocê empurra a trava. Clic. Você pisa fora da gaiola.");
            System.out.println("Você investiga a sala ao lado. É um escritório antigo.");
            jogador.ganharExp(30); // Bônus de Curiosidade
            
            String habilidade = jogador.getHabilidadeExploracao();
            System.out.printf("   | (Você tem a habilidade: [%s])\n", habilidade);
            
            // Simulação da descoberta baseada na habilidade (simplificado)
            if (habilidade.equals("Voo Silencioso")) {
                System.out.println(jogador.usarHabilidadeExploracao("janela"));
                System.out.println("   | Lá embaixo, no beco, você vê um cultista pintando um símbolo estranho no muro.");
            } else if (habilidade.equals("Garras Ágeis") || habilidade.equals("Aderência")) {
                System.out.println(jogador.usarHabilidadeExploracao("gaveta"));
                System.out.println("   | Dentro, há um pequeno talismã de madeira com um símbolo estranho.");
            } else {
                // Outros Pokémon encontram de outra forma
                System.out.println(jogador.usarHabilidadeExploracao("prateleira")); // Exemplo genérico
                System.out.println("   | Atrás da prateleira, um símbolo está pintado na parede.");
            }
            
            jogador.adicionarPista("SÍMBOLO DO CULTO");
            Util.pausar(2);

        } else {
            // CAMINHO B: FICAR QUIETO
            System.out.println("\nVocê se encolhe no fundo da gaiola. O medo é maior que a curiosidade.");
            jogador.incrementarInacao(); // Salva a inação
            System.out.printf("   | (Contador de Inação: %d)\n", jogador.getContadorInacao());
        }

        // Clímax do Capítulo
        System.out.println("\n(Clímax do Capítulo)");
        System.out.println("De repente, você ouve um GRITO vindo da sala da reunião.");
        System.out.println("Seguido pelo som de algo quebrando.");
        
        if (escolha == 1) {
            System.out.println("(Você corre de volta para a gaiola, fechando a porta a tempo!)");
        }
        
        System.out.println("O humano sai, pálido e tremendo de raiva.");
        System.out.println("Humano: \"Incompetente... ele me chamou de incompetente... É tudo culpa sua!\"");
        System.out.println("Ele te agarra e te leva para fora. No beco, um Rattata está encolhido.");
        System.out.println("Humano: \"Aquele... ele falhou. Nocauteie-o. AGORA.\"");
        Util.pausar(2);


        Inimigo rattata = new Inimigo("Rattata Ferido", 5, 2, 1, 1, 1);
        System.out.println("\n(Você entra em batalha contra o Rattata Nível 1 ferido.)");


        System.out.println("Você não quer lutar, mas o olhar do humano é assassino.");
        System.out.printf("%s ataca %s!\n", jogador.getNome(), rattata.getNome());
        int dano = jogador.atacar(rattata);
        System.out.printf("Você causou %d de dano. %s foi nocauteado.\n", dano, rattata.getNome());
        
        jogador.ganharExp(20);
        
        System.out.println("O humano parece um pouco satisfeito. \"Vamos para casa.\"");
        System.out.println("(Você se sente sujo por atacar outro Pokémon indefeso.)");
        
        jogador.ganharExp(50);
        
        jogador.mostrarStatus();
        
        System.out.println("\n(Fim do Capítulo 3.)");
        return ResultadoCapitulo.continuar();
    }
}