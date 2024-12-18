package GrMechMag.com.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase está enfocada a realizar tratamientos de cadenas de texto y transformaciones de valores a textos
 * @author MrSoru
 * @since 2024/12/18
 * */
public class TextManagement {

    private static String Empty = "";

    /**
     * Replica el texto ingresado la cantidad de veces especificada
     * @param Text Texto a replicar
     * @param Times Número de veces que se replicará el texto. </br>
     *              Si es 0 o menor se obtendrá un texto vacío
     * */
    public static String Replicate(String Text, int Times) {
        StringBuilder OutPut = new StringBuilder();
        if (Times <= 0) {
            return Empty;
        }
        for (int i = 0; i < Math.abs(Times); i++) {
            OutPut.append(Text);
        }
        return OutPut.toString();
    }
    /**
     * Replica el texto ingresado la cantidad de veces especificada
     * @param Times Número de veces que se replicará el texto. </br>
     *              Si es 0 o menor se obtendrá un texto vacío
     * @param Text Texto a replicar
     * */
    public static String Replicate(int Times, String Text) {
        return Replicate(Text, Times);
    }

    /**
     * Añade comillas simples al texto
     *
     * @param Text Texto al que se le añadirán las comillas simples
     * @return Texto con comillas simples al inicio y final
     */
    public static String SingleQuote(final String Text) {
        return "'" + Text + "'";
    }

    /**
     * Añade comillas dobles al texto
     *
     * @param Text Texto al que se le añadirán las comillas dobles
     * @return Texto con comillas dobles al inicio y final
     */
    public static String DouleQuote(final String Text) {
        return "\"" + Text + "\"";
    }

    /**
     * nueva linea de texto de formato UNIX
     *
     * @return Salto de línea UNIX
     */
    public static String NewLine() {
        return "\n";
    }

    /**
     * Añade nuevas lineas de texto de formato UNIX
     *
     * @param NumberOfLines Número de saltos de línea que se generarán
     * @return Salto de línea UNIX
     */
    public static String NewLine(int NumberOfLines) {
        if (NumberOfLines <= 1) {
            return NewLine();
        }
        return Replicate(NewLine(), NumberOfLines);
    }

    /**
     * Añade caracter de tabulador
     *
     * @return Carácter de tabulador
     */
    public static String NewTab() {
        return "\t";
    }

    /**
     * Añade tabulaciones de texto
     *
     * @param NumberOfTabs Número de tabulaciones que se generarán
     * @return Salto de línea UNIX
     */
    public static String NewTab(int NumberOfTabs) {
        if (NumberOfTabs <= 1) {
            return NewTab();
        }
        return Replicate(NewTab(), NumberOfTabs);
    }

    /**
     * Añade una tanulacion cruda de texto
     * @return Texto de ocho espacios
     * */
    public static String addRawTab() {
        return Replicate(" ", 8);
    }

    /**
     * Añade una tanulacion cruda de texto
     * @param NumberOfTabs Número de veces que se repliacará el tabulador en crudo
     * @return El texto de una tabulacion de 8 espacios segun el número de veces especificadas
     * */
    public static String addRawTab(int NumberOfTabs) {
        if (NumberOfTabs <= 1) {
            return addRawTab();
        }
        return Replicate(addRawTab(), NumberOfTabs);
    }

    /**
     * Genera un texto de treinta guiones
     * @return Texto de 30 guiones (-)
     * */
    public static String Separator() {
        return Replicate("-", 30);
    }

    /**
     * Genera un texto de guiones segun el ancho y longitud establecida
     * @param Length Longitud del texto de guines (Debe ser al menos uno, si es cero retorna un texto vacío)
     * @param Lines Número de veces que repite el texto en un salto de línea para un "ancho" de texto (Si es cero, retorna un texto vacío)
     * @return Texto de guines de longitud y ancho determinado
     * */
    public static String Separator(int Length, int Lines) {
        StringBuilder Line = new StringBuilder();
        if (Length <= 0) {
            Length = 1;
        }
        for (int i = 0; i < Lines; i++) {
            Line.append(Replicate("-", Length));
            Line.append(NewLine());
        }
        return Line.toString();
    }
    /**
     * Genera un texto con el número determinado de guiones
     * @param Length Lonqitud del texto (Debe ser al menos uno)
     * @return Texto de guiones (-)
     * */
    public static String Separator(int Length) {
        return Replicate("-", Length);
    }

    /**
     * Transforma el texto recibido a un formato de texto legible para el CMD de Windows
     * @param Texto Texto a transformar para CMD
     * @return Texto transformado para CMD
     * */
    public static String Transform4CMD(String Texto) {
        return Texto.replace(NewLine(), "`n").replace(NewTab(), "`t");
    }

    /**
     * Añade comillas dobles legibles para CMD
     * @param Texto Tesxto a añadir comillas dobles
     * @return Texto con entrecomillado para CMD
     * */
    public static String DoubleCMDQuotes(String Texto) {
        return "\\\"" + Texto + "\\\"";
    }

    /**
     * Transforma el número de segundos de a un formato HH:MM:SS
     * @param seconds Número de segundos
     * @return Texto de representacion de tiempo "HH:MM:SS"
     * */
    public static String TransformSecondsToTime(long seconds) {
        long time_Hours = seconds / 3600;
        long time_Minutes = (seconds % 3600) / 60;
        long time_Seconds = seconds % 60;
        return String.format("%02d:%02d:%02d", time_Hours, time_Minutes, time_Seconds);
    }

    /**
     * Obtiene la representacion de fecha Establecido en la ISO 8601
     * @param date Fecha a transformar
     * @return String con la fecha en formato "yyyy-MM-dd'T'HH:mm:ssZ"
     * */
    public static String ISO8601 (Date date){
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(date);
    }
}