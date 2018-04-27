package double_six_domino_set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 * classe que define os jogadores
 *
 * @author Guilherme Guedes
 */
public class Player {

    /**
     * vetor de pedras compradas para historico de partida
     */
    private final ArrayList<Bone> draw = new ArrayList<Bone>();

    /**
     * Determina quando o jogador fica bloqueado
     */
    private boolean blocked;
    /**
     * nome do jogador;
     */
    private String name;

    /**
     * pontos do jogador
     */
    private int scoring;

    /**
     * lista de pedras da mão do jogador
     */
    private ArrayList<Bone> hand = new ArrayList<Bone>();

    /**
     * lista que armazena o historico de pedras jogadas
     */
    private ArrayList<Bone> bonesPlayed = new ArrayList<Bone>();

    /**
     * lista que armazena o historico de pedras compradas do monte
     */
    private ArrayList<Bone> PurchasedBones = new ArrayList<Bone>();

    /**
     * determina se o jogador é humano ou bot
     */
    private final Bot bot;

    /**
     *
     * @param name nome do jogador
     * @param bot bot ou humano
     */
    public Player(String name, Bot bot) {
        this.name = name;
        this.bot = bot;
        this.scoring = 0;
        this.blocked = false;
    }

    /**
     *
     *
     * @param name adiciona nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * nome do jogador
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * adiciona pontos
     *
     * @param scoring
     */
    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    /**
     * pega pedra
     *
     * @param bone
     */
    public void setHand(Bone bone) {
        this.hand.add(bone);
    }

    /**
     * retorna pedra da mao
     *
     * @param value
     * @return
     */
    public Bone getHand(int value) {
        return hand.get(value);
    }

    /*
     * retorna quantas pedras o jogador tem na mao 
    pelo tamanho do array, usado pra fazer esse tipo de controle
     * @return hand
     */
    public ArrayList<Bone> sizeHand() {
        return hand;
    }

    /**
     * remove pedra da mao
     *
     * @param value
     */
    public void Removehand(int value) {
        hand.remove(value);
    }

    /**
     *
     * @return modo de jogador humano ou bot
     */
    public Bot getBot() {
        return bot;
    }

    /**
     * joga pedra na mesa e remove da mão
     *
     * @param value
     * @return
     */
    public Bone playBone(int value) {
        Bone aux;
        aux = getHand(value);
        this.bonesPlayed.add(aux);
        Removehand(value);
        return aux;
    }

    /**
     * retorna se e bou ou humano
     *
     * @return
     */
    public boolean isBot() {
        return getBot().getMod();
    }

    /**
     * retorna tamanho do vetor depedras jogadas usado pra fazer o controle
     *
     * @return pedras
     */
    public ArrayList<Bone> sizePlayeds() {
        return bonesPlayed;
    }

    /**
     *
     * @param value indice da pedra
     * @return pedra do indice desejado
     */
    public Bone getPlayeds(int value) {
        return this.bonesPlayed.get(value);
    }

    /**
     * adiciona a lista de pedras compradas do monte
     *
     * @param bone pedra
     */
    public void setDraw(Bone bone) {
        this.draw.add(bone);
    }

    /**
     *
     * @param position posiçao da pedra a mao do jogador
     * @return
     */
    public Bone getDraw(int position) {
        return this.draw.get(position);
    }

    /**
     * tamanho da lista de pedras comprada do monte
     *
     * @return lista de pedras comprada
     */
    public int sizeDraw() {
        return draw.size();
    }

    /**
     * pontos de cada jogador vence quem tiver menor ponto
     *
     * @return a soma de todos as pedras de cada jogador
     */
    public int Scoring() {
        for (int i = 0; i < sizeHand().size(); i++) {
            this.scoring = scoring + getHand(i).getValueR() + getHand(i).getValueR();
        }
        return this.scoring;
    }

    /**
     * controle de quando o jogador pula se chega nele novamente e ele estiver
     * bloqueado jogo encerra
     *
     * @param blocked bloqueia
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    /**
     * retorna bloqueio
     *
     * @return
     */
    public boolean getBlocked() {
        return blocked;
    }

}
