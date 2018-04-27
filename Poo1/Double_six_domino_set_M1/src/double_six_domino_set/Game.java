/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package double_six_domino_set;

import java.util.ArrayList;
import java.util.Collections;

/**
 * classe onde o jogo esta sendo montado
 *
 * @author Guilherme Guedes
 */
public class Game {

    /**
     * lista de pedras estanciada uma unica vez
     */
    private final ArrayList<Bone> game = new ArrayList<>();

    /**
     * tabuleiro do jogo
     */
    private final Table table = new Table();

    // private final  CreatePlayers ModPlayers = new CreatePlayers();
    /**
     * vetor de jogadores 2,3 ou 4
     */
    private Player[] players;

    /**
     *classe de validação
     */
    private final ValidationGame modGame = new ValidationGame();
    
    /**
     * classe de comunicação com o usuario
     */
    private final User_interface userInterface = new User_interface();
   
    /**
     * controla fim do jogo
     */
    private boolean  gameOver = false;

    /**
     * controla a vez do jogador que vai jogar
     * obtem o id do jogador conforme modo de jogo
     */
    private static int playersCounter;
    
    /**
     * contador de turno
     */
    private int turn = 0;

    /**
     * cria as 28 pedras do jogo
     */
    private void startBone() {
        int id = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = i; j < 7; j++) {
                game.add(new Bone(i, j));
                id++;
            }
        }
    }
    /**
     * incrementa rodada do jogador e entra 
     * em loop conforme modo de jogo
     */
    public void countPlayrs() {
        if (playersCounter == players.length - 1) {
            Game.playersCounter = 0;
        } else {
            Game.playersCounter++;
        }
    }
    /**
     * define que jogador esta jogando naquela rodada
     * @return retorna id do jogador
     */
    public int getCountPlayers() {
        return playersCounter;
    }

    /**
     * Embaralha as pedras
     */
    public void shuffle() {
        Collections.shuffle(game);
    }

    /**
     * move todas as pedras de game para o monte
     * O monte começa com as pedras
     */
    public void moveAllBoneFromGameToBoneyard() {
        for (int i = 0; i < game.size(); i++) {
            table.setBoneyard(game.get(i));
        }
    }

    /**
     * move 7 pedras inicialmente para cada jogador criado
     * o resto fica no monte
     */
    public void moveSevenBoneForPlayers() {

        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 7; j++) {
                players[i].setHand(table.getBoneyard(0));
                table.RemoveBoneyard(0);

            }

        }
    }

    /**
     * mostra tela modo de jogo para o usuario
     * trata a oçao que o usuario vai escolher
     * e cria numero de jogadores conforme a eacolha
     */
    public void startModGame() {
        userInterface.startingGame();
        modGame.startMod(modGame.validateMod(DataIn.readlnInt("->")));
    }

    /**
     * cria a quantidade de jogadroes conforme a escolha do usuario
     *  verificar classe creatPlayers 
     */
    public void createPlayers() {
        players = userInterface.createPlayers(modGame.getMod());
    }

    /**
     * mostra pedra na ordem esquerda direita
     *
     * @param valueL
     * @param valueR
     */
    public void printBone(int valueL, int valueR) {
        userInterface.printBone(valueL, valueR);

    }

   

    /**
     * retorna jogador com a maior pedra 6,6 ou 5,5 ou 4,4.......
     * caso jogador nao tenha pedras de valores duplo
     * jogador 1 inicia
     *
     * @return
     */
    public int startedBoneLarger() {
        int doublle = 6;
        while (doublle >= -1) {
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < 7; j++) {
                    if (players[i].getHand(j).getValueL() == doublle && players[i].getHand(j).getValueR() == doublle) {
                        return i;
                    }
                }
            }
            doublle--;
        }

        return 0;
    }

    /**
     * esse metodo serve para jogar a pedra no tabuleiro 
     * quando o jogador pula verifica se todos os jogadores ja pularam e termina o jogo
     * caso contrario reseta o modo de bloqueio após um jogador ter feito uma jogada
     * playBone joga pedra na mesa e remove da mao do jogador
     * @param player  id do jogador que joga na rodada
     * @param optionalKeyBoard joga a pedra que o usuario escolher no cado do bot a pedra encontrada na validaçao
     * @param sidOfTable determina de que lado a pedra vai ser encaixada na mesa
     * @param boneInverted determina se a pedra vai ser virada ou não
     * 
     */
    private void playerPlaysOnTheTable(int player, int optionalKeyBoard, int sidOfTable, boolean boneInverted) {
        if(modGame.getMod() == 1) {                  
            modGame.allPlayersBlockedOff1x2(players);
        }else 
            if (modGame.getMod() == 2) {
                modGame.allPlayersBlockedOff1x3(players);
            }else 
                if (modGame.getMod() == 3 || (modGame.getMod() == 4)) {
                    modGame.allPlayersBlockedOffMod1x4(players);
                }

        players[player].getHand(optionalKeyBoard).setSideOfBone(boneInverted);// mao do jogador na posicao escolhida recebe verdade ou false conforme lado da pedra
        table.setTable(players[player].playBone(optionalKeyBoard), sidOfTable);//aqui joga na mesa e ja remove da mão
        if (players[player].sizeHand().isEmpty()) {
            turn++;
            userInterface.printTurn(turn, players[player], table.sizeTable(), players[0].isBot());
            userInterface.gameOver(players[player].getName());
            return;
        } else {
            countPlayrs();
        }
        turn++;
        userInterface.printTurn(turn, players[player], table.sizeTable(), players[0].isBot());
          DataIn.waitEnter();

    }

   /**
    * destinado ao jogador humano essa classe faz comunicaçao com o ususario
    * mostra a mao e o usuario escolhe a pera que vai querer jogar
    * pula quando solicitado 
    * compra quando o monte nao estiver vazio
   
    */
    private void playHuman(Player player) {
        int optionKeyBoard;
        userInterface.printPlayHuman();
        userInterface.printHumanHand();
        optionKeyBoard = (modGame.validateBoneChoice(players[playersCounter].sizeHand().size()));
        if (optionKeyBoard > -1 && optionKeyBoard < players[0].sizeHand().size()) {
            if (table.sizeTable().isEmpty()) {
                playerPlaysOnTheTable(playersCounter, optionKeyBoard, 0, true);
            }
            if (players[playersCounter].getHand(optionKeyBoard).getValueR() == table.getEndL()) {
                playerPlaysOnTheTable(playersCounter, optionKeyBoard, 0, true);

            } else if (players[playersCounter].getHand(optionKeyBoard).getValueL() == table.getEndR()) {
                playerPlaysOnTheTable(playersCounter, optionKeyBoard, table.sizeTable().size(), true);
            } else if (players[playersCounter].getHand(optionKeyBoard).getValueL() == table.getEndL()) {
                playerPlaysOnTheTable(playersCounter, optionKeyBoard, 0, false);
            } else if (players[playersCounter].getHand(optionKeyBoard).getValueR() == table.getEndR()) {
                playerPlaysOnTheTable(playersCounter, optionKeyBoard, table.sizeTable().size(), false);
            }
        } else if (optionKeyBoard == -2 && table.sizeBoneyard().isEmpty() == false) {
            players[0].setDraw(table.getBoneyard(0));
            players[0].setHand(table.getBoneyard(0));
            table.RemoveBoneyard(0);
        } else if (optionKeyBoard == -3) {
            if (table.sizeBoneyard().isEmpty()) {
                userInterface.printTurn(turn, players[playersCounter], table.sizeTable(), players[0].isBot());
                User_interface.Next();
                players[playersCounter].setBlocked(true);
                countPlayrs();
                nextTurn();

            }
        }
    }

    /**
     * inteligencia do bot
     * determina qual pedra o bot vai jogar e em qual lado da mesa
     * tambem verifica se o jogador esta trancado e pula quando necessario
     */
    private void playBot(Player player) {

        for (int i = 0; i <= players[playersCounter].sizeHand().size(); i++) {
            if (players[playersCounter].getHand(i).getValueR() == table.getEndL() && players[playersCounter].sizeHand().isEmpty()) {
                playerPlaysOnTheTable(playersCounter, i, 0, true);
                break;
            } else if (players[playersCounter].getHand(i).getValueL() == table.getEndR()) {
                playerPlaysOnTheTable(playersCounter, i, table.sizeTable().size(), true);
                break;
            } else if (players[playersCounter].getHand(i).getValueL() == table.getEndL()) {
                playerPlaysOnTheTable(playersCounter, i, 0, false);
                break;
            } else if (players[playersCounter].getHand(i).getValueR() == table.getEndR()) {
                playerPlaysOnTheTable(playersCounter, i, table.sizeTable().size(), false);
                break;
            } else if (players[playersCounter].sizeHand().size() - 1 == i) {

                if (table.sizeBoneyard().isEmpty() == false) {//ele compra
                    players[playersCounter].setDraw(table.getBoneyard(0));
                    players[playersCounter].setHand(table.getBoneyard(0));
                    table.RemoveBoneyard(0);
                    i = 0;

                } else {
                    turn++;
                    // ele pula
                    userInterface.printTurn(turn, players[playersCounter], table.sizeTable(), players[0].isBot());
                    User_interface.Next();
                    players[playersCounter].setBlocked(true);
                    countPlayrs();
                    nextTurn();
                    break;
                }
            }
        }

    }

    /**
     * inicia quem tem a pedra [6|6] ou [5|5] ou .......
     * caso nenhum jogador tenha uma pedra dupla 
     * inicia o jogador 1
     * double é uma variavel que vai comparando a pedra do jogador para verifivar 
     * se sao iguais, caso nao ela decrementa ate chegar em[0|0], caso ninguem
     */
    public void startTurn() {

        playersCounter = startedBoneLarger();
        int doublle = 6;

        if (playersCounter == 0 && players[playersCounter].isBot() == false) {
            playHuman(players[playersCounter]);
        } else {
            for (int i = 6; i > -1; i--) {
                for (int j = 0; j < 7; j++) {
                    if (players[playersCounter].getHand(j).getValueL() == doublle && players[playersCounter].getHand(j).getValueR() == doublle && players[playersCounter].isBot()) {

                        playerPlaysOnTheTable(playersCounter, j, 0, true);
                        i = -1;
                    }
                }

            }
        }

    }

    /**
     * proxima rodada
     * verifica se o jogo nao esta trancado ou se ninguem bateu
     * caso contrario chama a proxima rodada 
     */
    public void nextTurn() {
        if (players[playersCounter].sizeHand().isEmpty()) {
            
            gameOver = true;
        } else if (modGame.allPlayersBlockedOn(players) == true) {
            gameOver = true;

            if (modGame.getMod() == 1) {
                modGame.PlayerWin1x2(players);
            } else if (modGame.getMod() == 2) {
                modGame.PlayerWin1x3(players);
            } else if (modGame.getMod() == 3 || (modGame.getMod() == 4)) {
                modGame.PlayerWin1x4(players);
            }
        } else if (players[playersCounter].isBot()) {
            playBot(players[playersCounter]);

        } else {
            playersCounter = 0;
            playHuman(players[playersCounter]);
        }
    }
    
    /**
     * startBone cria as pedras
     * shuffle embaralha as pedras
     * moveAllBoneFromGameToBoneyard(); move todas as pedras para o monte
     * startModGame verifica qual o modo de jogo 1x1,1x2,1x3,demo
     * createPlayers cria quantidade de jogadores conforme escolha do usuario
     * moveSevenBones move sete pedras para cada usuario criado o resto fica no monte
     * starterBoneLarge verifica quem  quem tem a maior pedra
     * startTurn inicia quem tem a pedra maior 
     * nextTurn chama proximo turno
     */
    public void run() {

        startBone();
        shuffle();
        moveAllBoneFromGameToBoneyard();
        startModGame();
        createPlayers();
        moveSevenBoneForPlayers();
        startedBoneLarger();
        startTurn();
        while (!gameOver) {
            nextTurn();
        }

    }

}
