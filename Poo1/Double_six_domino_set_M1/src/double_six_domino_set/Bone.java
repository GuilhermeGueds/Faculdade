package double_six_domino_set;



/**
 * classe Pedra
 * @author Guilherme Guedes
 */
public class Bone {
    
   
    
    /**
     * valor da pedra  do lado esquerdo 
     */
    private final int valueL;
    /**
     * valor direito do lado da pedra
     */
    private final int valueR;
    /**
     * lado em que a pedra vai ser omprimida na mesa
     */
    private boolean sideOfBone;
    /**
     * construtor 
     * @param valueL valor do lado esquerdo da pedra
     * @param valueR valor do lado direito da pedra
     */
    public Bone( int valueL, int valueR){ 
       
        this.sideOfBone = true;
        this.valueL = valueL;       
        this.valueR = valueR;    
    }
   
   /**
    * 
    * @return valor esquerdo da pedra
    */
    public int getValueL(){
        return valueL;
    }
    
     /**
     * 
     * @return valor direito da pedra
     */
    public int getValueR(){
        return valueR;
    }
    
    /**
     * verifica se a pedra vai ser girada na mesa quando jogada
     * 
     * @param sideOfBone gira pedra conforme o valor
     */
    public void setSideOfBone(boolean sideOfBone){
        this.sideOfBone = sideOfBone;    
    }
    /**
     * retorna valor do lado da pedra
     * @return 
     */
    public boolean getSideOfBone(){
        return sideOfBone;
    }
}
