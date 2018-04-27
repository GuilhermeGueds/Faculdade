/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Configuração da Aplicação.
 *
 * @author Guilherme Guedes e Daniel Passos
 */
public final class AppConfig {

    /**
     * Nome da Aplicaçao.
     */
    public static final String APP_NAME;

    /**
     * Versão da aplicação.
     */
    public static final String APP_VERSION;

    /**
     * Constante de data com formato brasileiro.
     */
    public static final DateTimeFormatter DATE_FORMAT;

    /**
     * Código de quebra de linha.
     */
    public static final String NEW_LINE;

    /**
     * Armazenar as configurações lidas de alguma fonte.
     */
    private static final ArrayList<Object> SETTINGS = new ArrayList<>();

    /**
     * Bloco static.
     */
    static {
        loadSettings();
        APP_NAME = (String) SETTINGS.get(0);
        APP_VERSION = (String) SETTINGS.get(1);
        DATE_FORMAT = (DateTimeFormatter) SETTINGS.get(2);
        NEW_LINE = (String) SETTINGS.get(3);
    }

    /**
     * Carrega as configurações de alguma fonte.
     */
    private static void loadSettings() {
        SETTINGS.add("Pizzaria Online");
        SETTINGS.add("1.0");
        SETTINGS.add(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        SETTINGS.add(System.getProperty("line.separator"));
    }
}
