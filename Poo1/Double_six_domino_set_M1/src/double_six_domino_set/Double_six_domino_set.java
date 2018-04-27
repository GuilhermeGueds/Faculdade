/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package double_six_domino_set;

/**
 *Jogo de domino 
 * @author Guilherme e Daniel
 */
public class Double_six_domino_set {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do {
            Game game = new Game();
            game.run();
        } while (!"n".equals(User_interface.playAgain()));
    }

}
