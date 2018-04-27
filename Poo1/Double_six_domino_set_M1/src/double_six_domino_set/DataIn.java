
package double_six_domino_set;
import java.util.Scanner;
/**
 *
 * @author Guilherme Guedes
 */
public class DataIn {
      /**
     * Arquivo para leitura diretamente do console (System.in).
     */
    private static Scanner in = new Scanner(System.in);

    /**
     * Lê uma linha do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return uma string com a linha lida
     */
    private static String readLine(String caption) {
	System.out.printf("%s ", caption);
	return in.nextLine();
    }

    /**
     * Lê uma string do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return uma string com a linha lida
     */
    public static String readlnString(String caption) {
	
        return readLine(caption);
    }

    /**
     * Lê um int do console.
     *
     * @param caption Texto que identifica o que está sendo solicitado (rótulo)
     * @return um int a partir da conversão da linha lida
     */
    public static int readlnInt(String caption) {
	return Integer.parseInt(readLine(caption));
    }

    /**
     * Aguarda até que um ENTER seja teclado no console.
     */
    public static void waitEnter() {
	readLine("\n\n pressione [ENTER] para continuar\n");
    }
    
  
    
}




