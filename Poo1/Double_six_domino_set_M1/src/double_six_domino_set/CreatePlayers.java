/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package double_six_domino_set;

/**
 * cria array de jogadores
 *
 * @author Gilherme Guedes Soares
 */
public class CreatePlayers {

    /**
     * modo de jogo 1x1 bot,
     *
     * @param nome
     * @return
     */
    public Player[] createPlayerMod1x1(String nome) {

        Player[] players = new Player[2];
        Player player1 = new Player(nome, Bot.HUMAN);
        Player player2 = new Player("Roy Batty", Bot.BOT);
        players[0] = player1;
        players[1] = player2;
        return players;
    }

    /**
     * modo de jogo 1x2 bot,
     *
     * @param nome
     * @return
     */
    public Player[] createPlayerMod1x2(String nome) {
        Player[] players = new Player[3];
        Player player1 = new Player(nome, Bot.HUMAN);
        Player player2 = new Player("Roy Batty", Bot.BOT);
        Player player3 = new Player("Leon Kowalski", Bot.BOT);
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        return players;
    }

    /**
     * modo de jogo 1x3 bot,
     *
     * @param nome
     * @return
     */
    public Player[] createPlayerMod1x3(String nome) {
        Player[] players = new Player[4];
        Player player1 = new Player(nome, Bot.HUMAN);
        Player player2 = new Player("Roy Batty", Bot.BOT);
        Player player3 = new Player("Leon Kowalski", Bot.BOT);
        Player player4 = new Player("Pris Stratton", Bot.BOT);
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        return players;
    }

    /**
     * todos os jogadores sao bot
     *
     * @return
     */
    public Player[] createPlayerModDemo() {
        Player[] players = new Player[4];
        Player player1 = new Player("Roy Batty", Bot.BOT);
        Player player2 = new Player("Leon Kowalski", Bot.BOT);
        Player player3 = new Player("Pris Stratton", Bot.BOT);
        Player player4 = new Player("Zhora Salome", Bot.BOT);
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        return players;
    }
}
