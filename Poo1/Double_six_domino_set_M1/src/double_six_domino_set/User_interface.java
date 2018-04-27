/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package double_six_domino_set;

import java.util.ArrayList;

/**
 *
 * @author Guilherme Guedes
 */
public class User_interface {
    
    
    CreatePlayers ModPlayers = new CreatePlayers();
    Player[] players;
    ValidationGame mod = new ValidationGame();
    Game game;
    Table table;

    // Player[] ModPlayers;
    public void startingGame() {
        System.out.println("-----------   Jogo de Domino   -----------------\n");
        System.out.println("modo de jogo\n");
        System.out.println("(1) - 1x1 \n" + "(2) - 1x2 \n" + "(3) - 1x3 \n" + "(4) - demonstração\n");

    }

    /**
     * chama metodo que cria vetor de jogadores
     *
     * @param value
     * @return
     */
    public Player[] createPlayers(int value) {
        switch (value) {
            case 1:
                players = ModPlayers.createPlayerMod1x1(DataIn.readlnString("\n Nome: "));
                break;
            case 2:
                players = ModPlayers.createPlayerMod1x2(DataIn.readlnString("\n Nome: "));
                break;
            case 3:
                players = ModPlayers.createPlayerMod1x3(DataIn.readlnString("\n Nome: "));
                break;
            case 4:
                players = ModPlayers.createPlayerModDemo();
                break;
        }
        System.out.println("");
        for (int i = 1; i <= players.length; i++) {
            System.out.println("jogador " + i + ": " + players[i - 1].getName());
        }
        System.out.println("\n -------------------iniciando o jogo------------------------");
        return players;
    }

    /**
     * desenha pedra e recebe valores por parametro
     *
     * @param endL
     * @param endR
     */
    public void printBone(int endL, int endR) {
        System.out.printf("[" + endL + "|" + endR + "]");
    }

    public void printHumanHand() {

        for (int i = 1; i <= players[0].sizeHand().size(); i++) {
            System.out.printf("("+i + ")-->" + "");
            printBone(players[0].getHand(i - 1).getValueL(), players[0].getHand(i - 1).getValueR());
            System.out.printf(" | ");
        }
        System.out.printf("(-1)-> comprar | (-2)--> pular\n");

    }

    public void printTurn(int turn, Player player, ArrayList<Bone> table, boolean modDemo) {
        System.out.println("\n");
        System.out.println("rodada: " + turn);
        System.out.println("jogador: " + player.getName());
        System.out.printf("mão: ");
        for (int i = 0; i < player.sizeHand().size(); i++) {
            if (player.isBot() == false || modDemo) {
                printBone(player.getHand(i).getValueL(), player.getHand(i).getValueR());
            } else {
               System.out.print("-");
            }
        }
        System.out.print("\npedras usadas: ");

        for (int i = 0; i < player.sizePlayeds().size(); i++) {

            printBone(player.getPlayeds(i).getValueL(), player.getPlayeds(i).getValueR());

        }
        System.out.print("\ncompradas: ");
            for(int i=0; i<player.sizeDraw();i++){
                printBone(player.getDraw(i).getValueL(), player.getDraw(i).getValueR());
            }
        
        
        System.out.print("\n------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("\nmesa: ");
        for (int i = 0; i < table.size(); i++) {

            if (table.get(i).getSideOfBone() == true) {
                printBone(table.get(i).getValueL(), table.get(i).getValueR());
            } else if (table.get(i).getSideOfBone() == false) {
                printBone(table.get(i).getValueR(), table.get(i).getValueL());
           }

        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void printPlayHuman() {
        System.out.printf("\nEscolha sua pedra: ");

    }

    public final static String printErro() {
        return ("valor invalido, Digite novamente:");

    }
    
    public final static String invalidMove(){
        return ("monte possui pedra");
    } 
    public final  void gameOver(String name){
         
        System.out.println("\n"+name + "  Venceu"+"\n Fim de Jogo");
    }
    public final static void Next(){
          System.out.println( "\nNão possui pedra e monte esta vazio passou a vez");
    }
    public final static void PlayerWin(String name){
        System.out.println("\n"+name + "venceu por pontos"+ "\nfim de jogo");
    }
    public final static String playAgain(){
        System.out.println("\nDeseja jogar novamente? S/N");
        return DataIn.readlnString("-->");
    }
}
