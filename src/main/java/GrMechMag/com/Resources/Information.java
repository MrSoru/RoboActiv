package GrMechMag.com.Resources;
import java.util.ArrayList;

/**
 * Esta clase está dedicada a la información del proyecto
 * @author MrSoru
 * @since 2024/12/17
 * */
public class Information {
    public static String Version = " v1 Rev1";

    public static String ProgramName = "RoboActiv";

    public static String LogName = "GrMechMag";

    public static String Acronimo = "Robot De actividades";

    public static String Fuente = "Excel";

    public static String Plataforma = "Windows";

    private static ArrayList<String> Devs = new ArrayList<>();

    public static String getDevs() {
        Devs.add("Arturo Meza Garcia (Mr. Soru) - Dev " + ProgramName+"\n");
        String String2Return = "";
        return Devs.stream().reduce(String2Return, String::concat);
    }

    public static String getVersion() {
        return Version;
    }

    public static String getProgramName() {
        return ProgramName;
    }

    public static String getLogName() {
        return LogName;
    }

    public static String getAcronimo() {
        return Acronimo;
    }

    public static String getFuente() {
        return Fuente;
    }

    public static String getPlataforma() {
        return Plataforma;
    }
}