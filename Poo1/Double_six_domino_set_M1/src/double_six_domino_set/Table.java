package double_six_domino_set;

import java.util.ArrayList;

/**
 * tabuleiro do jogo
 *
 * @author Guilherme Guedes
 */
public class Table {

    /**
     * criando o tabuleiro do jogo em uma lista
     */
    private ArrayList<Bone> table = new ArrayList<>();

    /**
     * monte armazena as pedras que nao iniciam na mao dos jogadores
     */
    private final ArrayList<Bone> boneyard = new ArrayList<>();

    /**
     * ponta da mesa lado esquerdo armazena valor das pontas quando jogada uma
     * pedra
     */
    private int endL;

    /**
     * ponta da mesa lado direito armazena valor das pontas quando jogada uma
     * pedra
     */
    private int endR;

    /**
     * construtor as pontas recebem esse valor inicial para a jogada inicial diz
     * que se a pponta valer 1000 aceita qualquer pedra depois disso as pontas
     * so aceitarao pedras de valores iguais
     */
    public Table() {

        this.endL = 1000;
        this.endR = 1000;
    }

    /**
     * verifica se as pontas sao compativeis quando jogado a pedera valor inicia
     * em 1000 para aceitar qualquer valor na primeira rodada
     *
     * @param bone pedra
     * @param position posiçao
     */
    public void setTable(Bone bone, int position) {

        if (position == 0 && endL == bone.getValueR()) {
            this.endL = bone.getValueL();
        } else if (position == 0 && endL == bone.getValueL()) {
            this.endL = bone.getValueR();
        } else if (position == table.size() && endR == bone.getValueL()) {
            this.endR = bone.getValueR();
        } else if (position == table.size() && endR == bone.getValueR()) {
            this.endR = bone.getValueL();
        } else if (this.endL == 1000 && this.endR == 1000) {
            this.endL = bone.getValueL();
            this.endR = bone.getValueR();
        }
        this.table.add(position, bone);
    }

    /**
     * retorna tamanho do array de mesa ultilizado para controle
     *
     * @return
     */
    public ArrayList<Bone> sizeTable() {
        return table;
    }

    /**
     * retorna valor da mesa
     *
     * @param value
     * @return
     */
    public Bone getTable(int value) {
        return table.get(value);
    }

    /**
     * adiciona pedra ao monte
     *
     * @param bone pdra
     */
    public void setBoneyard(Bone bone) {
        this.boneyard.add(bone);
    }

    /**
     * retorna lista de pedra que esta no monte
     *
     * @param value posiçao da pedra
     * @return boneyard
     */
    public Bone getBoneyard(int value) {
        return boneyard.get(value);
    }

    /**
     * retorna o tamanho do array ultilizado para contrtole
     *
     * @return tamanho do array
     */
    public ArrayList<Bone> sizeBoneyard() {
        return boneyard;
    }

    /**
     * remove pedrada mão
     *
     * @param value posiçao da pedra
     */
    public void RemoveBoneyard(int value) {
        boneyard.remove(value);
    }

    /**
     * ultilizado para controlar a ponta esquerda
     *
     * @return ponta da mesa lado esquerdo
     */
    public int getEndL() {
        return this.endL;
    }

    /**
     * ultilizado para controlar a ponta direita
     *
     * @return ponta da mesa lado direita
     */
    public int getEndR() {
        return this.endR;
    }

    /**
     * coloca o valor lado esquerdo
     *
     * @param endL
     */
    public void setEndL(int endL) {
        this.endL = endL;
    }

    /**
     * coloca o valor do lado direito
     *
     * @param endR
     */
    public void setEndR(int endR) {
        this.endR = endR;
    }
}
