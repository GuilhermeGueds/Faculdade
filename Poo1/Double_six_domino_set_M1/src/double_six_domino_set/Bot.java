package double_six_domino_set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * verifica se é bot ou humano ou
 *
 * @author Guilherme Guedes
 */
public enum Bot {

    HUMAN("human", false),
    BOT("bot", true);
    
    /**
     * descriçao humano ou bot
     */
    private final String description;

    /**
     * modole verdadeiro para bot e falso para humano
     */
    private final boolean mod;

    /**
     * construtor
     *
     * @param description
     * @param mod
     */
    private Bot(String description, boolean mod) {
        this.description = description;
        this.mod = mod;
    }

    /**
     * retorna descriçao
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * retorna modo
     * @return 
     */
    public boolean getMod() {
        return mod;
    }
}
