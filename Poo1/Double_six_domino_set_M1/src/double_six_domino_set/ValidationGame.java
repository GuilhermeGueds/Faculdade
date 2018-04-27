package double_six_domino_set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guilherme Guedes
 */
public class ValidationGame {

    /**
     * modo de jogo
     */
    private int mod;

    /**
     * construtor
     *
     * @param mod
     */
    public void setMod(int mod) {
        this.mod = mod;
    }

    /**
     * retorna o modo de jogo
     *
     * @return
     */
    public int getMod() {
        return mod;
    }

    /**
     * valida se a opçao de menu e 1,2,3,4 depois retorna valor valido
     *
     * @param value
     * @return
     */
    public int validateMod(int value) {

        if (value == 1 || value == 2 || value == 3 || value == 4) {
            return value;
        } else {
            return validateMod(DataIn.readlnInt(User_interface.printErro()));
        }

    }

    /**
     * valida escolha do jogador quando vai jogar a pedra na mesa
     *
     * @param size
     * @return
     */
    public int validateBoneChoice(int size) {

        int value = DataIn.readlnInt("-->");
        while (!(value > 0 && value <= size || value == -1 || value == -2)) {
            value = DataIn.readlnInt(User_interface.printErro());
        }
        return value - 1;

    }

    /**
     * verifica se todos os jogadores estao bloqueado. caso isso aconteça jogo
     * encerra apos a mao retornar para o primeiro jogador bloqueado
     *
     * @param players
     * @return verdadeiro ou falso
     */
    public boolean allPlayersBlockedOn(Player[] players) {
        boolean x = false;
        switch (this.mod) {
            case 1:
                if (players[0].getBlocked() == true && players[1].getBlocked() == true) {
                    x = true;
                } else {
                    x = false;
                }
                break;
            case 2:
                if (players[0].getBlocked() == true && players[1].getBlocked() == true && players[2].getBlocked() == true) {
                    x = true;
                } else {
                    x = false;
                }
                break;
            case 3:

                if (players[0].getBlocked() == true && players[1].getBlocked() == true && players[2].getBlocked() == true && players[3].getBlocked() == true) {
                    x = true;
                } else {
                    x = false;
                }
                break;
            case 4:

                if (players[0].getBlocked() == true && players[1].getBlocked() == true && players[2].getBlocked() == true && players[3].getBlocked() == true) {
                    x = true;
                } else {
                    x = false;
                }
                break;
            default:
                break;
        }

        return x;
    }

    /**
     * metodo que escolhe o modo de jogo serve para validar o tipo de jogo que o
     * usuario escolher
     *
     * Numero de jogadores sao criados a partir dessa escolha
     *
     * @param value
     */
    public void startMod(int value) {
        switch (value) {
            case 1:
                mod = 1;
                break;
            case 2:
                mod = 2;
                break;
            case 3:
                mod = 3;
                break;
            case 4:
                mod = 4;
                break;
        }
    }

    /**
     * desbloqueia todos os jogadores quando um jogador joga a pedra na mesa.
     * Necessario criar um para cada tipo de jogo
     *
     * @param players lista de jogadores criado na partida
     */
    public void allPlayersBlockedOffMod1x4(Player[] players) {

        players[0].setBlocked(false);
        players[1].setBlocked(false);
        players[2].setBlocked(false);
        players[3].setBlocked(false);
    }

    /**
     * desbloqueia todos os jogadores quando um jogador joga a pedra na mesa.
     * Necessario criar um para cada tipo de jogo
     *
     * @param players lista de jogadores criado na partida
     */
    public void allPlayersBlockedOff1x3(Player[] players) {
        players[0].setBlocked(false);
        players[1].setBlocked(false);
        players[2].setBlocked(false);
    }

    /**
     * desbloqueia todos os jogadores quando um jogador joga a pedra na mesa.
     * Necessario criar um para cada tipo de jogo
     *
     * @param players lista de jogadores criado na partida
     */
    public void allPlayersBlockedOff1x2(Player[] players) {

        players[0].setBlocked(false);
        players[1].setBlocked(false);

    }

    /**
     * serve para controlar jofador que vence quando a partida acaba por
     * bloqueio da mesa foi necessario criar dessa forma pois o vetor que
     * controla a quantidade de jogador é o mesmo, o que determina o seu tamanho
     * e a escolha do usuario controla quando sao 2 jogadores
     *
     * @param players jogadores sao passado por parametro
     */
    public void PlayerWin1x2(Player[] players) {
        if (players[0].Scoring() < players[1].Scoring()) {
            User_interface.PlayerWin(players[0].getName());
        } else {
            User_interface.PlayerWin(players[1].getName());
        }
    }

    /**
     * serve para controlar jofador que vence quando a partida acaba por
     * bloqueio da mesa foi necessario criar dessa forma pois o vetor que
     * controla a quantidade de jogador é o mesmo, o que determina o seu tamanho
     * e a escolha do usuario controla quando sao 3 jogadores
     *
     * @param players jogadores sao passado por parametro
     */
    public void PlayerWin1x3(Player[] players) {
        if (players[0].Scoring() < players[1].Scoring() && players[0].Scoring() < players[2].Scoring()) {
            User_interface.PlayerWin(players[0].getName());
        } else if (players[1].Scoring() < players[2].Scoring()) {
            User_interface.PlayerWin(players[1].getName());
        } else {
            User_interface.PlayerWin(players[2].getName());
        }
    }

    /**
     * serve para controlar jofador que vence quando a partida acaba por
     * bloqueio da mesa foi necessario criar dessa forma pois o vetor que
     * controla a quantidade de jogador é o mesmo, o que determina o seu tamanho
     * e a escolha do usuario controla quando sao 4 jogadores
     *
     * @param players jogadores sao passado por parametro
     */
    public void PlayerWin1x4(Player[] players) {
        if (players[0].Scoring() < players[1].Scoring() && players[0].Scoring() < players[2].Scoring() && players[0].Scoring() < players[3].Scoring()) {
            User_interface.PlayerWin(players[0].getName());
        } else if (players[1].Scoring() < players[2].Scoring() && players[1].Scoring() < players[3].Scoring()) {
            User_interface.PlayerWin(players[1].getName());
        } else if (players[2].Scoring() < players[3].Scoring()) {
            User_interface.PlayerWin(players[2].getName());
        } else {
            User_interface.PlayerWin(players[3].getName());
        }

    }
}
